package bean.impl;

import bean.ISchool;
import bean.Klass;
import bean.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author spring-starter -- chengyan
 * @date 2021/3/31 16:26
 **/
@Data
public class School implements ISchool {

    @Autowired(required = true)
    Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void doSomeThing(){

        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);

    }
}
