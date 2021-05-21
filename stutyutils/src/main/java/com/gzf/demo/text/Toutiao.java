package com.gzf.demo.text;

import java.util.Scanner;

public class Toutiao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int k  = scanner.nextInt();
        int[] cha = new int[n];
        int num = 0;
        int r = 0;
        int[] remark = new int[2*n];
        for(int i = 0; i < n; i++){
            cha[i] = scanner.nextInt();
        }
        for (int j = 0; j<n-1;j++){
            for (int m = j+1;m<n;m++){
                if (((cha[j] - cha[m]) == k)||((cha[j] - cha[m]) == -k)){
                    num+=1;
                    remark[r] = cha[j];
                    remark[r+1] = cha[m];
                    r+=2;
                }
            }
        }
        for (int be = 0;be<r-1;be++){
            for (int br = be+2;br<r;br++){
                if ((remark[be] == remark[br])&&(remark[be+1] == remark[br+1])){
                    num=num-1;
                }
                br++;
            }
            be++;
        }
        System.out.println(num);
    }
}
