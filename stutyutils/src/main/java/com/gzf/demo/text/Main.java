package com.gzf.demo.text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0;i<n;i++){
            a[i] = scanner.nextInt();
        }
        int[] ary1 = new int[n];
        int[] ary2 = new int[n];
        int[] result = new int[n];
        int p =0,o =0;
        for (int m = 0;m<n;m++){
            if (a[m] == 0){
                ary1[p] = a[m];
                p++;
            }else {
                ary2[o] = a[m];
                o++;
            }
        }
        System.arraycopy(ary2,0,result,0,o);
        System.arraycopy(ary1,0,result,o,p);
        for (int l = 0;l<n;l++){
            System.out.println(result[l]);
        }
    }

}
