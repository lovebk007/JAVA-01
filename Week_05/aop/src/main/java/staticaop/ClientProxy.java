package staticaop;

/**
 * 静态代理
 * @author aop -- chengyan
 * @date 2021/3/12 14:51
 **/
public class ClientProxy {

    public static void main(String[] args){

        WeightManager weightManager = new WeightManagerImplProxy(new WeightManagerImpl());

        // 增重
        weightManager.weightGain();

        // 减重
        weightManager.weightLost();

        // 体重维持平衡
        weightManager.weightBalance();

    }
}
