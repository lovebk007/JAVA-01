package javabean;

import javabean.impl.BookImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author spring -- chengyan
 * @date 2021/3/26 14:42
 **/
@Configuration
public class BookConfig {

    @Bean
    public Book book(){
        return new BookImpl();
    }
}
