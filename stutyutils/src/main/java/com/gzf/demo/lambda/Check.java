package com.gzf.demo.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demoList
 * @description: lambda表达式类型检查
 * @author: Gaozf
 * @create: 2020-03-11 15:00
 **/
public class Check {

    public static void test(MyInterface<String, List> myInterface) {
        List<String> list = myInterface.strategy("hello", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        /**
         * jvm会根据上下文检查，x是string类型，y是list类型
         *
         */
        test((x, y) -> {
            y.add(x);
            return y;
        });

    }
}

@FunctionalInterface
interface MyInterface<T, R> {
    R strategy(T t, R r);
}
