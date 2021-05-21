package com.gzf.demo.algorithm;

/**
 * @program: demoList
 * @description: (用动态规划解决)一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @author: Gaozf
 * @create: 2019-12-24 16:43
 **/
public class dongtaiguihua {
    public int jumpCount(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        //n=2的时候可以跳两次1级或者一次2两级
        else if (n == 2) {
            return 2;
        } else {
            return jumpCount(n - 1) + jumpCount(n - 2);
        }
    }

    /**
     * （贪心）
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int jumpAll(int n) {
        if (n <= 2) {
            return n;
        } else {
            return jumpAll(n - 1)*2;
        }

    }
}
