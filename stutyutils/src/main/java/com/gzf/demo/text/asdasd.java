package com.gzf.demo.text;

import java.util.Scanner;

public class asdasd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int H = scanner.nextInt();
        int[] Tlist = new int[N];
        for (int i =0;i<N;i++){
            Tlist[i] = scanner.nextInt();
        }
        int position = countBig(K,H, Tlist);
        System.out.println(position);
    }
    public static int countBig(int K,int H, int[] Tlist){
        int p = 0;
        for (int i = 0;i<K;i++){
            if (Tlist[0]>K){
                return 0;
            }
            p = swap(p,Tlist[i]);
        }
        return p;
    }
    public static int swap(int p,int t){
        int newP = p+2*(t-p);
        return newP;
    }
}
