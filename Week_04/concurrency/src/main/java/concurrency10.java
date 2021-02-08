import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 15:17
 **/
public class concurrency10 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start=System.currentTimeMillis();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<Integer> future = executorService.submit(Homework03::sum);

        System.out.println("异步计算结果为：" + future.get());

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

        executorService.shutdown();
    }
}
