import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:44
 **/
public class concurrency06 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start=System.currentTimeMillis();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(Homework03::sum);

        System.out.println("异步计算结果为："+completionService.take().get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        executorService.shutdown();
    }
}
