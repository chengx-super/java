package com.technology.reflection.realize;

import com.technology.reflection.method.DateNumFormatToObject;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author chenguangxu
 * @create 2020/2/26 14:32
 */
public class Demo2 {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 通过反射调用 方法
        System.err.println(DateNumFormatToObject.class);
        Class<?> aClass = Class.forName("com.technology.reflection.method.DateNumFormatToObject");
        Object instance = aClass.getConstructor().newInstance();
        DateNumFormatToObject formatToObject = (DateNumFormatToObject) instance;
        Map<String, Object> map = formatToObject.dateNumFormatMap(10, 3, "YY-MM-dd");
        System.err.println(map);
    }


}
