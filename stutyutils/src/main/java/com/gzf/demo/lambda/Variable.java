package com.gzf.demo.lambda;

/**
 * @program: demoList
 * @description: lambda对变量的访问
 * @author: Gaozf
 * @create: 2020-03-11 14:43
 **/
public class Variable {
    String s1 = "全局变量";
    //1.匿名内部类中对变量的访问
    public void testInnerClass(){
        String s2 = "局部变量";
        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                //访问全局变量
//                System.out.println(this.s1);//this关键字表示的是当前匿名内部类的对象
                System.out.println(s1);
                System.out.println(s2);//局部变量的访问，不能对局部变量进行数据修改[final]
                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    //2、lambda表达式变量的捕获
    public void testLambda() {
        String s2 = "lambda局部变量";
        new Thread(() -> {
            String s3 = "lambda内部变量";
            //访问全局变量
            System.out.println(s1);
            System.out.println(this.s1);//this表达的是所属方法所在的对象
            //局部变量
            System.out.println(s2);
//            s2 = "22222";不能进行修改，默认局部变量为final
            //内部变量
            System.out.println(s3);
            s3 = "改变后的s3 lambda";
            System.out.println(s3);
        }).start();
    }

    public static void main(String[] args) {
        Variable variable = new Variable();
        variable.testInnerClass();
        variable.testLambda();
    }

}
