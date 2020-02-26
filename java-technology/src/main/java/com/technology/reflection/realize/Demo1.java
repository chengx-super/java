package com.technology.reflection.realize;

import com.technology.reflection.method.Books;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chenguangxu
 * @create 2020/2/26 12:03
 */
public class Demo1 {

    /**
     * 基础反射理解
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 正常调用
        Books books1 = new Books();
        books1.setName("反射书籍");
        books1.setAuthor("chen");
        books1.setType("技术");
        System.err.println(books1);
        System.err.println(books1.getClass());

        // 反射实现 获取对象
        Class<?> aClass = Class.forName("com.technology.reflection.method.Books");
        Object instance = aClass.getConstructor().newInstance();
        Books books = (Books) instance;
        System.err.println(books);
        System.err.println(books.getClass());


        // 反射实现 获取对象的方法
        Class<?> aClass1 = Class.forName("com.technology.reflection.method.Books");
        Books books2 = (Books) aClass1.getConstructor().newInstance();
        Method setName = aClass1.getMethod("setName", String.class);
        Method setAuthor = aClass1.getMethod("setAuthor", String.class);
        Method setType = aClass1.getMethod("setType", String.class);
        setName.invoke(books2, "获取对象的方法");
        setAuthor.invoke(books2, "反射实现");
        setType.invoke(books2, "反射");
        System.err.println(books2);
        System.err.println(books2.getClass());

    }

}
