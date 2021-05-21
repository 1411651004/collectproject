package com.gzf.demo.text;

import java.util.Scanner;

public class Meituan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        sc.close();
        System.out.println(getJuli(strA,strB));
    }
    public static int getJuli(String a,String b){
        String str = "";
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int k = 0;
        if (str1.length == str2.length){
            for (int i = 0;i<str1.length;i++){
                if (str1[i] != str2[i]){
                    k+=1;
                }
            }
        }else {
            for (int m = 0; m < str1.length - str2.length + 1; m++) {
                for (int i = 0; i < str2.length; i++) {
                    if (str2[i] != str1[i + m]) {
                        k += 1;
                    }
                }
            }
        }
        return k;
    }
}
