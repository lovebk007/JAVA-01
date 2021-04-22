package javabean.impl;

import javabean.Book;

/**
 * @author spring -- chengyan
 * @date 2021/3/26 15:26
 **/
public class BookImpl implements Book {

    @Override
    public void read(){
        System.out.println("学生正在读书");
    }
}
