package com.gzf.demo.lambda;

/**
 * @program: demoList
 * @description: 方法的重栽对于lambda表达式的影响
 * @author: Gaozf
 * @create: 2020-03-11 15:34
 **/
public class Overload {
    interface Param1 {
        void outInfo(String info);
    }

    interface Param2 {
        void outInfo(String info);
    }

    //定义重载的方法
    public void lambdaMethod(Param1 param) {
        param.outInfo("hello param1");
    }
    public void lambdaMethod(String str,Param2 param) {
        param.outInfo(str);
    }

    public static void main(String[] args) {
        Overload overload = new Overload();

        overload.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });
        String str = "gzf";
        overload.lambdaMethod(str,(Param2) System.out::println);
//        overload.lambdaMethod(new Param2() {
//            @Override
//            public void outInfo(String info) {
//                System.out.println(info);
//            }
//        });
        /**
         * lambda表达式存在类型检查->自动推导lambda表达式的目标类型
         * lambdaMethod()->方法->重载方法
         *      ->param1函数式接口
         *      ->param2函数式接口
         *      调用方法->传递lambda表达式->自动推导
         *          -> param1 | param2
         */
//        overload.lambdaMethod((String info) -> {
//            System.out.println(info);
//        });
    }
}
