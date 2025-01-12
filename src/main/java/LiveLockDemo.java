public class LiveLockDemo {
    /*
     * A livelock situation occurs when two or more threads keep changing their state in response to each other without making any progress
     * Thread t1 and Thread t2 attempt to acquire two resources.
     * When one thread realizes that the resource it needs is locked by the other thread,
     * it releases its own lock to help the other thread proceed.
     * However, this results in both threads continuously releasing and acquiring locks without
     * making any real progress, thus causing a livelock.
     */
    static class Resource {
        private boolean isLocked;

        public Resource(boolean isLocked) {
            this.isLocked = isLocked;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void unlock() {
            isLocked = false;
        }

        public void lock() {
            isLocked = true;
        }
    }

    public static void main(String[] args) {
        final Resource resource1 = new Resource(true);
        final Resource resource2 = new Resource(true);

        // Thread 1
        Thread t1 = new Thread(() -> {
            while (resource1.isLocked()) {
                System.out.println("Thread 1: waiting for resource 1 to be unlocked");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            resource1.lock();
            System.out.println("Thread 1: locked resource 1");

            while (resource2.isLocked()) {
                System.out.println("Thread 1: unlocking resource 1 to help Thread 2");
                resource1.unlock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                resource1.lock();
                System.out.println("Thread 1: locked resource 1 again");
            }
            resource2.lock();
            System.out.println("Thread 1: locked resource 2");
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            while (resource2.isLocked()) {
                System.out.println("Thread 2: waiting for resource 2 to be unlocked");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            resource2.lock();
            System.out.println("Thread 2: locked resource 2");

            while (resource1.isLocked()) {
                System.out.println("Thread 2: unlocking resource 2 to help Thread 1");
                resource2.unlock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                resource2.lock();
                System.out.println("Thread 2: locked resource 2 again");
            }
            resource1.lock();
            System.out.println("Thread 2: locked resource 1");
        });

        t1.start();
        t2.start();
    }
}
