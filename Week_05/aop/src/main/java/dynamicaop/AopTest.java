package dynamicaop;

import org.junit.jupiter.api.Test;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 15:08
 **/
public class AopTest {

    @Test
    public void fun1() {

        ProxyFactory factory = new ProxyFactory(
                (Target) () -> System.out.println("我是目标对象的实现类"),
                         () -> System.out.println("我是前置增强"),
                         () -> System.out.println("我是后置增强")
        );
        Target targetProxy = (Target) factory.createProxy();
        targetProxy.targetMethod();
    }

}

