import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author concurrency -- chengyan
 * @date 2021/2/7 14:43
 **/
public class concurrency05 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long start=System.currentTimeMillis();

        int result = CompletableFuture.supplyAsync(Homework03::sum).get();

        System.out.println("异步计算结果为："+result);

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
