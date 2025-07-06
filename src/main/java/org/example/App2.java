package org.example;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

class Address {
    String country = "Ukraine ";
    String city = "Kyiv";
}
class Person {
    int name = 111;
    String surname = "Hello";
    String[] phones = {"123", "12345", "321"};
    Address address = new Address();
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
            if (value.getClass().isArray()) {
                sb.append('"')
                        .append(field.getName())
                        .append('"')
                        .append(":");
                sb.append("[");
                for  (int i = 0; i < Array.getLength(value); i++) {
                            sb.append('"')
                            .append(Array.get(value, i))
                            .append('"');
                            if(i + 1 != Array.getLength(value)) {
                                sb.append(",");
                            }

                }
                sb.append(']');
                sb.append(",");
            }
            else if(value != null && !value.getClass().isPrimitive() && !(value instanceof String) &&
                    !(value instanceof Number) && !(value instanceof Boolean)) {
                   sb.append('"')
                           .append(field.getName())
                           .append('"')
                           .append(": ")
                           .append("{");
                   Field[] fields1 = value.getClass().getDeclaredFields();
                for (int i = 0; i < fields1.length; i++) {
                    fields1[i].setAccessible(true);
                    Object valueOfField = fields1[i].get(value);
                    sb.append('"')
                            .append(fields1[i].getName())
                            .append('"')
                            .append(": ")
                            .append('"')
                            .append(valueOfField)
                            .append('"');
                    if(i + 1 != fields1.length) {
                        sb.append(",");
                    }
                }
            }
            else {
                sb.append('"')
                        .append(field.getName())
                        .append('"')
                        .append(": ")
                        .append('"')
                        .append(value)
                        .append('"').append(',');
            }
        }

        sb.append("}");

        System.out.println(sb.toString());
    }
}
