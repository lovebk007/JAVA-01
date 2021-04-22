package bytebuddyagent;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 17:37
 **/
public class AgentTest {

    private void method1() throws Exception {
        System.out.println("this is method 1.");
        Thread.sleep(500);
    }

    private void method2() throws Exception {
        System.out.println("this is method 2.");
        Thread.sleep(500);
    }

    public static void main(String[] args) throws Exception {

        AgentTest test = new AgentTest();

        test.method1();
        test.method2();
    }
}
