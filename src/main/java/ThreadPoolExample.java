import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Executing " + name + " on " + Thread.currentThread().getName());
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

            for (int i = 1; i <= 5; i++) {
                Task task = new Task("Task " + i);
                executorService.execute(task);
            }

            executorService.shutdown();
        }
    }
}
