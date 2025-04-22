package org.example;

import java.lang.reflect.*;

public class MyTestFramework {
    public static void test(Class<?>... cls) throws Exception {
        for (Class<?> cl : cls) {
            Method[] methods = cl.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class)) {
                    Boolean result = (Boolean) method.invoke(null);
                    if (!result) {
                        System.out.println("Test " + method.getName() + " failed");
                    }
                }
            }
        }

        System.out.println("Tests passed");
    }
}
