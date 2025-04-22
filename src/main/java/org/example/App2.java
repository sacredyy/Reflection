package org.example;

import java.lang.reflect.Field;

class Person {
    int name = 111;
    String surname = "Hello";
}

public class App2 {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();

        Class<?> cls = Person.class;
        StringBuilder sb = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();

        sb.append("{");

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(person);

            sb.append('"')
                    .append(field.getName())
                    .append('"')
                    .append(": ")
                    .append('"')
                    .append(value)
                    .append('"').append(',');

        }

        sb.append("}");

        System.out.println(sb.toString());
    }
}
