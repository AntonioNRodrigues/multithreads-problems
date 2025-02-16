import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class BarrierTask implements Runnable {
    private final CyclicBarrier barrier;

    public BarrierTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> System.out.println("All threads have reached the barrier."));

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new BarrierTask(barrier)).start();
        }
    }
}
