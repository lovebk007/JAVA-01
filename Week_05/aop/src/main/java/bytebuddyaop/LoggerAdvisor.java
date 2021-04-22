package bytebuddyaop;

import net.bytebuddy.asm.Advice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 16:14
 **/
public class LoggerAdvisor {

    @Advice.OnMethodEnter
    public static void onMethodEnter(@Advice.Origin Method method, @Advice.AllArguments Object[] arguments) {
        if (method.getAnnotation(Weight.class) != null) {
            System.out.println("Enter " + method.getName() + " with arguments: " + Arrays.toString(arguments));
        }
    }

    @Advice.OnMethodExit
    public static void onMethodExit(@Advice.Origin Method method, @Advice.AllArguments Object[] arguments, @Advice.Return Object ret) {
        if (method.getAnnotation(Weight.class) != null) {
            System.out.println("Exit " + method.getName() + " with arguments: " + Arrays.toString(arguments) + " return: " + ret);
        }
    }
}
