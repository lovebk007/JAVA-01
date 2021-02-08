import java.util.concurrent.*;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:44
 **/
public class concurrency07 {

    private static volatile int result;

    private static Exchanger<Integer> exchanger = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {

        long start=System.currentTimeMillis();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executorService.submit(new Thread(() -> {
            try {
                result = Homework03.sum();
                exchanger.exchange(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        System.out.println("异步计算结果为："+exchanger.exchange(result));

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
