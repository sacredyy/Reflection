package org.example;

import java.lang.annotation.*;

@Inherited // наследование
@Target(value=ElementType.TYPE) // тип, метод, поле
// @Target(value={ElementType.TYPE, ElementType.FIELD}) // тип, метод, поле
@Retention(value= RetentionPolicy.RUNTIME) // жизненный цикл
public @interface MyAnnotation {
    String param1() default "string"; // значение параметра
    int param2();
}
