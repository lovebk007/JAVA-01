package xmlbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author spring -- chengyan
 * @date 2021/3/26 15:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    String courseName;
    double mark;
    List<String> students;


    public void course() {

        System.out.println("课程："+courseName+" 绩点为："+mark);

        System.out.println("选课学生：");

        Optional.ofNullable(students)
                .orElseGet(ArrayList::new)
                .forEach(System.out::println);
    }
}
