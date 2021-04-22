//package dynamicaop;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//
///**
// * @author aop -- chengyan
// * @date 2021/3/18 14:34
// **/
//public class DynamicDemo {
//
//    public void fun1() {
//
//        //通过本类可以获取加载本类的类加载器，使用这个类加载器来加载我们要创建的动态对象
//        ClassLoader loader = this.getClass().getClassLoader();
//        InvocationHandler handler = (proxy, method, objects) -> null;
//        //获得我们想要的动态对象
//        Object object = Proxy.newProxyInstance(loader, new Class[] { DemoOne.class, DemoTwo.class }, handler);
//    }
//
//}
