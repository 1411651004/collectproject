package com.gzf.demo.lambda;

import java.util.UUID;
import java.util.function.*;

/**
 * @program: demoList
 * @description: jdk中常见的函数式接口
 * @author: Gaozf
 * @create: 2020-03-11 09:14
 **/
public class FunctionInterface {

    /**
     * java.util.function提供了大量的函数式接口
     * Predicate 接收参数T对象，返回一个boolean类型结果
     * Consumer 接收参数T对象，没有返回结果
     * Function 接收参数T对象，返回R对象
     * Supplier 不接收任何参数，查找通过get()获取指定类型对象
     * UnaryOperator 接收参数T对象，执行业务处理后，返回更新的T对象
     * BinaryOperator 接受两个T对象，执行业务处理后，返回一个T对象
     */

    public static void main(String[] args) {
        //接收参数T对象，返回一个boolean类型结果
        Predicate<String> predicate = (String username) -> {
            return "admin".equals(username);
        };
        Predicate<String> pre = "admin"::equals;

        System.out.println(pre.test("manager"));
        System.out.println(pre.test("admin"));

        //接收参数T对象，没有返回结果
        Consumer<String> consumer = (String message) -> {
            System.out.println("要发送的消息："+message);
            System.out.println("消息发送完成");
        };

        consumer.accept("高振芳牛逼。。。");

        //接收参数T对象，返回R对象
        Function<String,Integer> function = (String gender) -> {
            return "man".equals(gender) ? 0 : 1;
        };
        Function<String, Integer> fc = gender -> "man".equals(gender) ? 0 : 1;

        System.out.println(function.apply("man"));
        System.out.println(function.apply("woman"));

        //不接收任何参数，查找通过get()获取指定类型对象
        Supplier supplier = () -> {
            return UUID.randomUUID().toString();
        };
        Supplier sp = () -> UUID.randomUUID().toString();

        System.out.println(supplier.get());

        //接收参数T对象，执行业务处理后，返回更新的T对象
        UnaryOperator<String> unaryOperator = (String img) -> {
            return img += "[100*200]";
        };
        UnaryOperator<String> uo = img -> img += "[100*200]";

        System.out.println(unaryOperator.apply("原图--"));

        //接受两个T对象，执行业务处理后，返回一个T对象
        BinaryOperator<Integer> binaryOperator = (Integer a,Integer b) -> {
            return a > b ? a : b;
        };
        BinaryOperator<Integer> bo = (d, e) -> d > e ? d : e;

        System.out.println(binaryOperator.apply(12,13));
    }



}
