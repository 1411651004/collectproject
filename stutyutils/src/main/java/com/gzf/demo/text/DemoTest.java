package com.gzf.demo.text;

public class DemoTest {
    public String str = "6";
    public static int v=0;
    static final int i=12;

    private static int x=100;
    static {
        System.out.println("静态代码块");
    }
    public void print(){
        System.out.println("普通代码块");
    }
    public static void main(String[] args) {

        DemoTest d1 = new DemoTest();
        d1.print();
        DemoTest d2 = new DemoTest();
        d2.print();
        System.out.println(v);
        System.out.println(100+5+"is");
        String a = new String("xyz");
        String b = new String("xyz");
        Boolean s = a.equals(b);
        System.out.println(s);
    }


    public void change(String a) {
         a =new String("book");
    }
}
