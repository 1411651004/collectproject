package com.gzf.demo.algorithm;

import java.util.Stack;

/**
 * @program: demoList
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: Gaozf
 * @create: 2019-12-24 14:29
 **/
public class stackByduilie {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    //进栈
    private void push(int node) {
        stack1.push(node);
    }

    //出栈
    private int push() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }


}
