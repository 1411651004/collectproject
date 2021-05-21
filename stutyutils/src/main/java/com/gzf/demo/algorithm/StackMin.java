package com.gzf.demo.algorithm;

import java.util.Iterator;
import java.util.Stack;

/**
 * @program: demoList
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @author: Gaozf
 * @create: 2019-12-25 10:47
 **/
public class StackMin {
    Stack<Integer> stack = new Stack<>();

    private void pop() {
        stack.pop();
    }

    private void push(int node) {
        stack.push(node);
    }
    //peek是获取栈顶元素，但不移出此元素
    private int peek() {
        return stack.peek();
    }

    private int min() {
        int min = stack.peek();
        int temp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (min > temp) {
                min = temp;
            }
        }
        return min;
    }
}
