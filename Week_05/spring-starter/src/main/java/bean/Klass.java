package bean;

import lombok.Data;

import java.util.List;

/**
 * @author spring-starter -- chengyan
 * @date 2021/3/31 16:28
 **/
@Data
public class Klass {

    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }
}
