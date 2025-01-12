public class StarvationDemo {
/*
Thread starvation occurs when a thread is perpetually denied access to resources, usually due to other higher-priority threads taking precedence.
we have a high-priority thread and a low-priority thread that both require access to the same lock object.
The high-priority thread is continuously running in an infinite loop, which means it consistently holds the lock.
As a result, the low-priority thread is starved and never gets a chance to acquire the lock and run.
Starvation can be a tricky problem to solve, especially in complex systems, so it's essential to design your synchronization mechanisms carefully to avoid it.
 */


    public static void main(String[] args) {
        final Object lock = new Object();

        // High priority thread
        Thread highPriorityThread = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("High priority thread running");
                }
            }
        });

        // Low priority thread
        Thread lowPriorityThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Low priority thread running");
            }
        });

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}
