import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:43
 **/
public class concurrency03 {

    private static volatile int result;

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                                 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5, true),
                                 Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        executorService.submit(new Thread(()->{
            reentrantLock.lock();
            try {
                result = Homework03.sum();
                condition.signal();
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }));

        reentrantLock.lock();
        try {
            condition.await();
            System.out.println("异步计算结果为："+result);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
     }
}