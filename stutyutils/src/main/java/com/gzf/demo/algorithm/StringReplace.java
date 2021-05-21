package com.gzf.demo.algorithm;

/**
 * @program: demoList
 * @description: 字符串替换
 * @author: Gaozf
 * @create: 2019-12-24 11:11
 **/
public class StringReplace {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("gao zhen fang");
        String str = sb.toString();
        System.out.println(str.replace(" ","%20"));
    }
}
