package com.technology.reflection.method;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenguangxu
 * @create 2020/2/26 11:07
 */
@Data
public class Books implements Serializable {

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 类型
     */
    private String type;

}
