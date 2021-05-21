package com.gzf.demo.text;

public class deng {
    public static void main(String[] args) {
        int[] suzu = new int[]{2, 4, 3, 7, 2,5};
        int[] newsuzu = new int[suzu.length];
        int x = 3;
        int m = 0,n = 0;
        int b = 0,c = 0;
        for (int s = 0;s<suzu.length;s++){
            if (suzu[s]>=x){
                b++;
            }else {
                c++;
            }
        }
        int[] linshi1 = new int[c];
        int[] linshi2 = new int[b];

        for (int i = 0,p = 0,l = 0;i<suzu.length;i++){
            if (suzu[i]<x){
                linshi1[l] = suzu[i];
                l++;
            }else {
                linshi2[p] = suzu[i];
                p++;
            }
        }
        System.arraycopy(linshi1,0,newsuzu,0,linshi1.length);
        System.arraycopy(linshi2,0,newsuzu,linshi1.length,linshi2.length);
    }


}
