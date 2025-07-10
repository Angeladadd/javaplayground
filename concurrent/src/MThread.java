import java.sql.Time;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class MRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("test runnable");
    }
}
class MCallable implements Callable<Integer> {
    private final ThreadLocal<String> local = new ThreadLocal<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public Integer call() {
        if (local.get() == null) {
            local.set(new Date().toString());
        }
        System.out.printf("test call, thread created at %s%n", local.get());
        return atomicInteger.getAndIncrement();
    }
}

public class MThread {
    final static private ExecutorService executorService = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Test MRunnable
        Thread thread = new Thread(new MRunnable());
        thread.start();
        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread1.start();
        // Test MCallable
        Callable<Integer> callable = new MCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        System.out.println(futureTask.get());
        // Test thread pool
        FutureTask<Integer> futureTask1 = new FutureTask<>(callable);
        executorService.execute(futureTask1);
        executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        System.out.println(futureTask1.get());
        executorService.shutdown();
    }
}