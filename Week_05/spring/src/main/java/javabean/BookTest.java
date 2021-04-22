package javabean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author spring -- chengyan
 * @date 2021/3/26 15:06
 **/
public class BookTest {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BookConfig.class);

        Book book = context.getBean(Book.class);

        book.read();
    }
}
