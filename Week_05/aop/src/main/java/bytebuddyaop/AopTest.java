package bytebuddyaop;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 16:08
 **/
public class AopTest {

    public static void main(String[] args) throws Exception{

        WeightService weightService = new ByteBuddy()
                .subclass(WeightService.class)
                .method(ElementMatchers.any())
                .intercept(Advice.to(LoggerAdvisor.class))
                .make()
                .load(WeightService.class.getClassLoader())
                .getLoaded()
                .newInstance();

        weightService.weightFoo(120);
        weightService.weightBar(220);
    }
}
