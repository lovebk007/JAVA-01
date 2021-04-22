package springbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author spring -- chengyan
 * @date 2021/3/26 14:30
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SchoolConfig.class)
public class TeachTest {

    @Autowired  public Teacher teacher;

    @Test
    public void test(){
        teacher.teach();
    }
}
