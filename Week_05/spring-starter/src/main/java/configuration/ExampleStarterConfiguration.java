package configuration;

import bean.Klass;
import bean.Student;
import bean.impl.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author spring-starter -- chengyan
 * @date 2021/4/1 15:24
 **/

@Configuration
public class ExampleStarterConfiguration {

    @Bean
    public Student student() {
        return new Student(100, "KK100");
    }

    @Bean
    public Klass klass() {

        List<Student> stuList = new ArrayList<>();

        stuList.add(student());

        Klass k1 = new Klass();
        k1.setStudents(stuList);
        return k1;
    }

    @Bean
    public School getSchool() {
        return new School();
    }
}
