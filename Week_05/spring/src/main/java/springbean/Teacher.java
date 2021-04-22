package springbean;

import org.springframework.stereotype.Component;

/**
 * @author spring -- chengyan
 * @date 2021/3/22 16:15
 **/

@Component
public class Teacher {

    public void teach(){
        System.out.println("老师正在上课");
    }
}
