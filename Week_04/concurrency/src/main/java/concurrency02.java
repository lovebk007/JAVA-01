import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:43
 **/
public class concurrency02 {

    private static volatile int result;

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executorService.submit(new Thread(() -> {
            result = Homework03.sum();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        countDownLatch.await();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
