
/* The above code snippet demonstrates the use of the  wait()  and  notify()  methods in Java.
    The  produce()  method is synchronized on the  lock  object and waits for the consumer to notify it.
    The  consume()  method is also synchronized on the  lock  object and notifies the producer to resume.
    The  main()  method creates two threads, one for the producer and one for the consumer.
    The producer thread calls the  produce()  method, which waits for the consumer to notify it.
    The consumer thread calls the  consume()  method, which notifies the producer to resume.
    When you run the code, you should see the following output:
    Producer is producing...*/

class WaitNotifyExample {
    private final Object lock = new Object();

    public void produce() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Producer is producing...");
            lock.wait();
            System.out.println("Producer resumed.");
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Consumer is consuming...");
            lock.notify();
            System.out.println("Consumer finished.");
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();

        Thread producer = new Thread(() -> {
            try {
                example.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                example.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
