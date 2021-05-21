package com.gzf.demo.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sss {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String n = scanner.nextLine();
//        String n1 = scanner.nextLine();
//        System.out.println(4);
        List<String> accountList = new ArrayList<>();
        accountList.add("xongjiang");
        accountList.add("lujunyi");
        accountList.add("wuyong");
        accountList.add("linchong");
        accountList.add("luzhishen");
        accountList.add("likui");
        accountList.add("wusong");

        // map() 中间操作，map()方法接收一个Functional接口
        accountList = accountList.stream().map(x->"梁山好汉:" + x).collect(Collectors.toList());

        // filter() 添加过滤条件，过滤符合条件的用户
        accountList = accountList.stream().filter(x-> x.length() > 5).collect(Collectors.toList());

        // forEach 增强型循环
        accountList.forEach(x-> System.out.println("forEach->" + x));
        accountList.forEach(x-> System.out.println("forEach->" + x));
        accountList.forEach(x-> System.out.println("forEach->" + x));

        // peek() 中间操作，迭代数据完成数据的依次处理过程
        accountList.stream()
                .peek(x -> System.out.println("peek 1: " + x))
                .peek(x -> System.out.println("peek 2:" + x))
                .forEach(System.out::println);

        accountList.forEach(System.out::println);

    }
}
