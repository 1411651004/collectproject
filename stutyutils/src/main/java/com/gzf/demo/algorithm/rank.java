package com.gzf.demo.algorithm;

import java.util.ArrayList;

public class rank {
    public static void bubblesort(int[] arr) {
        /*冒泡排序
         *两个for循环嵌套
         * 外面的for循环决定一个长度为m的数组要比较多少轮（m-1）才能完成排序
         * 里面的for循环决定每一轮循环中要做多少次才能结束，每一轮的最后一个已经拍好序了（m-1-i）
         * */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

    }

    public static void selectsort(int[] arr) {
        /*选择排序
        * 两个for循环嵌套
        * 外面的for 循环是几个数据要进行比较，最后一个不需要比较所以是m-1
        * 里面的for 循环是每一轮比较的过程，是要与外面循环进行比较的数据，随着其实位后移而减少
        * */
        for (int i = 0; i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */
    public static void main(String[] args) {
        int[] input = new int[]{4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> al = new ArrayList<Integer>();
        if (k > input.length) {
            //return al;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            al.add(input[input.length - i - 1]);
        }
        for (Integer temp:al) {
            System.out.print(temp);
        }
    }
}
