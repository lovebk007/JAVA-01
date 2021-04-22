package staticaop;

/**
 * @author aop -- chengyan
 * @date 2021/3/12 14:46
 **/
public class WeightManagerImplProxy implements WeightManager {

    private final WeightManager weightManager;

    public WeightManagerImplProxy(WeightManager weightManager) {

        this.weightManager = weightManager;
    }


    @Override
    public void weightGain() {

        System.out.println("我是代理商WeightManagerImplProxy");

        System.out.println("start->weightGain");

        weightManager.weightGain();

        System.out.println("success->weightGain");

    }

    @Override
    public void weightLost() {

        System.out.println("我是代理商WeightManagerImplProxy");

        System.out.println("start->weightLost");

        weightManager.weightLost();

        System.out.println("success->weightLost");

    }

    @Override
    public void weightBalance() {

        System.out.println("我是代理商WeightManagerImplProxy");

        System.out.println("start->weightBalance");

        weightManager.weightBalance();

        System.out.println("success->weightBalance");
    }
}
