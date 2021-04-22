package staticaop;

/**
 * @author aop -- chengyan
 * @date 2021/3/12 14:33
 **/
public interface WeightManager {

    /**
     * 增重
     */
    void weightGain();

    /**
     * 减重
     */
    void weightLost();

    /**
     * 体重平衡维持
     */
    void weightBalance();
}
