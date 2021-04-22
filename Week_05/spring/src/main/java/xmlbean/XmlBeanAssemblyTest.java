package xmlbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author spring -- chengyan
 * @date 2021/3/30 15:48
 **/
public class XmlBeanAssemblyTest {


    @Test
    public void xmlBeanTest(){

        String xmlPath = "spring/spring-bean.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Course course = (Course) applicationContext.getBean("course");

        course.course();

    }
}
