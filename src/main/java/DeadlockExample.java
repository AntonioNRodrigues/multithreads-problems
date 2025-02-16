record Resource(String name) {

    public synchronized void use(Resource other) {
        System.out.println(Thread.currentThread().getName() + " using " + name + " and waiting for " + other.name());
        other.use(this);
    }
}

public class DeadlockExample {
    /*"RUN AT YOUR OWN RISK  ---> DEADLOCK!!!!!"*/

    public static void main(String[] args) {
        Resource resource1 = new Resource("Resource1");
        Resource resource2 = new Resource("Resource2");

        Thread t1 = new Thread(() -> resource1.use(resource2), "Thread1");
        Thread t2 = new Thread(() -> resource2.use(resource1), "Thread2");

        t1.start();
        t2.start();
    }
}
