package com.gzf.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demoList
 * @description: 区分数组中奇偶
 * @author: Gaozf
 * @create: 2019-12-24 09:46
 **/
public class qufenjiou {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
        reOrderArray(array);
        for (int index: array) {
            System.out.print(index+" ");
        }
    }

    /**
     * 空间复杂度为O1
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
     *
     * @param array
     */
    private static int[] reArray(int[] array) {
        int begin = 0;
        int end = array.length-1;
        int temp = 0;
        while (begin < end) {
            //找到第一个偶数
            while (array[begin] % 2 != 0 && begin < end) {
                begin++;
            }
            //找到最后一个奇数
            while (array[end] % 2 != 1 && begin < end) {
                end--;
            }
            //交换位置
            temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }
        return array;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
     * @param array
     */
    private static int[] reOrderArray(int[] array) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            if(array[i]%2==0){
                list2.add(array[i]);
            }else{
                list1.add(array[i]);
            }
        }
        list1.addAll(list2);
        for(int j=0;j<list1.size();j++){
            array[j] = list1.get(j);
        }
        return array;
    }
}
