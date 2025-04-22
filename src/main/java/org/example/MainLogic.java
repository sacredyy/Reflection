package org.example;

public class MainLogic {

    public static int sum(int x, int y) {
        return x + y;
    }

    @Test
    public static boolean test1() {
        return (sum(1, 2) == 3 && sum(12, 14) == 26);
    }

    @Test
    public static boolean test2() {
        return (sum(10, -9) == 1);
    }

    public static void main(String[] args) throws Exception {
        MyTestFramework.test(MainLogic.class, Integer.class);
    }
}
