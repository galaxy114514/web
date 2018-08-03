package utils;

import java.io.File;

public class test {
    private static String s1;
    private static String s111;
    private static int i;
    private final String cx;

    public test() {
        cx = m1();
        Object o= new Object();
    }

    private String m1() {
        String cx;
        cx = "cx";
        return cx;
    }

    public static void main(String[] args) {
        if (true) {
            s111 = s1;
            s111 = "abc";
            i = 0;
        }
        try {
            File file=new File("abc.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
