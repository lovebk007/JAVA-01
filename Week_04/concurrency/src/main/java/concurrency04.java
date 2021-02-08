import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:43
 **/
public class concurrency04 {

    private static volatile int result;
    public static void main(String[] args)  {

        long start=System.currentTimeMillis();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        executorService.submit(new Thread(() -> result = Homework03.sum()));

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
