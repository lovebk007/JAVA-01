package staticaop;

/**
 * @author aop -- chengyan
 * @date 2021/3/12 14:36
 **/
public class WeightManagerImpl implements WeightManager {

    @Override
    public void weightGain() {
        System.out.println("2021.01吃胖了10斤！");
    }

    @Override
    public void weightLost() {
        System.out.println("2021.02至2021.03减掉了10斤！");
    }

    @Override
    public void weightBalance() {
        System.out.println("2021.04体重维持！");
    }
}
