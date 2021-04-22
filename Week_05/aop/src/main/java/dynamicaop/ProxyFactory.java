package dynamicaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 14:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProxyFactory {

    // 目标对象
    private Object targetObject;
    // 前置增强
    private BeforeAdvice beforeAdvice;
    // 后置增强
    private AfterAdvice afterAdvice;

    /**
     * 生成代理对象
     *
     * @return 代理对象
     */
    public Object createProxy() {
        // 给出三大参数
        ClassLoader loader = this.getClass().getClassLoader();
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler handler = (proxy, method, args) -> {
            // 如果前置增强不为空，执行前置增强
            if (beforeAdvice != null) {
                beforeAdvice.before();
            }
            // 执行目标方法
            Object result = method.invoke(targetObject, args);
            // 如果后置增强不为空，执行后置增强
            if (afterAdvice != null) {
                afterAdvice.after();
            }
            // 返回目标方法执行结果
            return result;
        };
        return Proxy.newProxyInstance(loader, interfaces, handler);
    }
}
