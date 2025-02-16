import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private final CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working...");
            Thread.sleep(1000); // Simulate work
            System.out.println(Thread.currentThread().getName() + " finished working.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) {
        int numberOfWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numberOfWorkers);

        for (int i = 0; i < numberOfWorkers; i++) {
            new Worker(latch).start();
        }

        try {
            latch.await(); // Wait for all workers to finish
            System.out.println("All workers have finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
