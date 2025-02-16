import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000); // Simulate long-running task
        return "Task completed";
    }
}

public class FutureExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            MyTaskExecutorService task = new MyTaskExecutorService();

            Future<String> future = executorService.submit(task);

            try {
                System.out.println("Waiting for the task to complete...");
                String result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            executorService.shutdown();
        }
    }
}
