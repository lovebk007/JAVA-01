import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 15:17
 **/
public class concurrency09 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start=System.currentTimeMillis();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        FutureTask<Integer> futureTask = new FutureTask<>(Homework03::sum);

        executorService.submit(futureTask);

        System.out.println("异步计算结果为："+futureTask.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
