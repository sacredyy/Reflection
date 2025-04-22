package org.example;

import java.lang.reflect.*;
import java.util.Date;

public class App {

    static private final class Test {
        public String s1 = "Hello";
        private int a = 2;
        protected long b = 7;

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public long getB() {
            return b;
        }

        public void setB(long b) {
            this.b = b;
        }

        public void doJob(String a, Integer b, Date c) {
            System.out.println("DoJob");
        }
    }

    static class X {
        private int secret = 777;
    }

    public static void main( String[] args ) throws Exception {
        Class<?> cls = Test.class;

        // 1
        System.out.println(cls.getName());

        // 2
        int mods = cls.getModifiers();
        if (Modifier.isAbstract(mods)) {
            System.out.println("Abstract");
        }
        if (Modifier.isInterface(mods)) {
            System.out.println("Interface");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("Final");
        }
        if (Modifier.isStatic(mods)) {
            System.out.println("Static");
        }

        // 3
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

        // 4
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println(parameterType.getName());
            }

            System.out.println("------");
        }

        // 5
        Test t = new Test();
        t.setS1("Hello");

        Method method = cls.getMethod("setS1", String.class);
        method.invoke(t, "World");

        System.out.println(t.getS1());

        // 6
        X x = new X();
        cls = x.getClass();

        Field field = cls.getDeclaredField("secret");
        field.setAccessible(true);

        System.out.println(field.getInt(x));

        field.setInt(x, 888);
        System.out.println(field.getInt(x));
    }
}
