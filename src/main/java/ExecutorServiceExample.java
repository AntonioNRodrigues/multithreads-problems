import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTaskExecutorService implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing task on " + Thread.currentThread().getName());
    }
}

public class ExecutorServiceExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            for (int i = 0; i < 5; i++) {
                executorService.execute(new MyTaskExecutorService());
            }

            executorService.shutdown();
        }
    }
}
