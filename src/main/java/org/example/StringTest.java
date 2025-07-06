package org.example;

import java.lang.reflect.*;

public class StringTest {
    private String str1 = "a";
    private String str2 = "b";
    private String str3 = "c";
    private String str4 = "c";
    // ...
    public static void main(String[] args) throws IllegalAccessException {
        StringTest t = new StringTest();
        Class<?> cls = StringTest.class;
        Field[] fileds = cls.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for (Field field : fileds) {
            field.setAccessible(true);
            sb.append(field.get(t));
        }
        System.out.println(sb.toString());
    }
}

