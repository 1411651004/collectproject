package com.gzf.demo.algorithm;

import java.util.Scanner;

/**
 * @program: demoList
 * @description: 字符串反转
 * @author: Gaozf
 * @create: 2019-12-24 10:14
 **/
public class StringReverse {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String line = sc.nextLine();
        char_reverse(line);
        word_reverse(line);
    }

    private static void char_reverse(String line) {
        //方法1
        StringBuilder str1 = new StringBuilder();
        char[] chars = line.toCharArray();
        for (int i = chars.length-1;i>=0;i--) {
            str1.append(chars[i]);
        }
        System.out.print(str1.toString());
        System.out.println();
        //方法2
        StringBuilder str2 = new StringBuilder(line);
        System.out.print(str2.reverse().toString());
        System.out.println();
    }

    private static void word_reverse(String line) {
        String[] str = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
