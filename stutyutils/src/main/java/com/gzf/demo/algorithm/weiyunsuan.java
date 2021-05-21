package com.gzf.demo.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: demoList
 * @description:
 * @author: Gaozf
 * @create: 2020-01-06 10:48
 **/
public class weiyunsuan {
    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 3, 2, 3};
        System.out.println(yihuo(a));

    }
    /**
     * 一个整型数组里除了一个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
     */
    public static int yihuo(int[] arr)  {
        int result = 0;
        for (int temp:arr) {
            result ^= temp;
        }
        return result;
    }

    /**
     解法1：
    1、思路：
    (1)对于出现两次的元素，使用“异或”操作后结果肯定为0，那么我们就可以遍历一遍数组，对所有元素使用异或操作，
     那么得到的结果就是两个出现一次的元素的异或结果。
    (2)因为这两个元素不相等，所以异或的结果肯定不是0，也就是可以再异或的结果中找到1位不为0的位，例如异或结果的最后一位不为0。
    (3)这样我们就可以最后一位将原数组元素分为两组，一组该位全为1，另一组该位全为0。
    (4)再次遍历原数组，最后一位为0的一起异或，最后一位为1的一起异或，两组异或的结果分别对应着两个结果。
    2、复杂度：
      （1）时间复杂度：第一次循环，将所有元素异或得到对应结果，时间开销为O(n)；第二次循环，找出第一次异或结果为1的位，时间开销为O(32)；
     第三次循环，根据为1的位将元素分为两组进行异或得到两个结果，时间复杂度为O(n)，所以总的时间复杂度为T(n) = 2*O(n)+O(32) = O(n)。
      （2）空间复杂度：常数，因为只分配了两个空间用于结果的保存，因此空间复杂度为常数。
     */
    public static void yihuo2(int[] arr) {
        int[] result = new int[2];
        //res为两不同数异或的结果
        int res = 0;
        for (int temp:arr) {
            res ^= temp;
        }
        //找到不为0的位置
        int index = 1;
//        while ((index & res) == 0) {
//            index <<= 1;
//        }
        for (int i = 0; i < 32; i++) {
            if ((index & res) == 0) {
                index <<= 1;
            } else {
                break;
            }
        }
        //根据这个位置是否为1分为两个数组
        for (int temp : arr) {
            if ((index & temp) == 0) {
                result[0] ^= temp;
            } else if ((index & temp) == 1) {
                result[1] ^= temp;
            }
        }
    }

    /**
     * 解法2：用Map对应的键值key就是数组中的元素，value就是这个元素出现的次数。
     */
    public static void queryNumByMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp: arr) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        //遍历一遍map
        Set<Integer> set = map.keySet();
        for (int i : set) {
            if (map.get(i) == 1) {
                System.out.println(i+" ");
            }
        }
    }
}
