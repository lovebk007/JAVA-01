import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:44
 **/
public class concurrency08 {

    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        RecursiveTask<Integer> task = new CurrencyForkJoinTask(20);

        int result = forkJoinPool.invoke(task);

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }


    private static class CurrencyForkJoinTask extends RecursiveTask<Integer> {

        private final int count;

        public CurrencyForkJoinTask(int count) {
            this.count = count;
        }

        @Override
        protected Integer compute() {
            if (count <= 2) {
                return count;
            }
            CurrencyForkJoinTask task1 = new CurrencyForkJoinTask(count - 1);
            task1.fork();
            CurrencyForkJoinTask task2 = new CurrencyForkJoinTask(count - 2);
            return task2.compute() + task1.join();
        }
    }
}
