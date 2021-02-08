import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:43
 **/
public class concurrency01 {

    private static volatile int result;

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        long start=System.currentTimeMillis();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executorService.submit(new Thread(() -> {
            result = Homework03.sum();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }));

        cyclicBarrier.await();
        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }
}
