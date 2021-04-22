package bytebuddyaop;

/**
 * @author aop -- chengyan
 * @date 2021/3/18 16:07
 **/
public class WeightService {

    @Weight
    public int weightFoo(int value) {
        System.out.println("weightFoo: " + value);
        return value;
    }

    public int weightBar(int value) {
        System.out.println("weightBar: " + value);
        return value;
    }
}
