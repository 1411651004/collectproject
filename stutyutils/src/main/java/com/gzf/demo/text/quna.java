package com.gzf.demo.text;

        import java.util.Arrays;
        import java.util.Scanner;

public class quna {
    static int[] flag = new int[100];
    static int index = 0;// 记录当前
    static boolean temp = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        numGroup(arr, 0, arr.length, sum);
        if (temp) {
            System.out.println("perfect");
        }else {
            System.out.println("good");
        }

    }
    public static void numGroup(int[] arr, int start, int length, int sum) {
        if (sum == 0) {
            temp = true;
            return;
//            for (int j = 0; j < index; j++) {
//                //System.out.print(flag[j]);
//                temp = true;
//                return;
//            }
            //System.out.println("good");
        } else {
            for (int i = start; i < length; i++) {
                //flag[index++] = arr[i];
                index++;
                numGroup(arr, i + 1, length-1, sum - arr[i]);
            }
        }
        index--;
    }
}
