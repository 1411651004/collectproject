package com.gzf.demo.operation;

import java.util.Scanner;

public class mainTest {
    public static void main(String[] args) {
        try {
            System.out.println("请选择运算符号：");
            Scanner scanner_fuhao = new Scanner(System.in);
            String type = scanner_fuhao.nextLine();
            //用简单工厂模式去进行判断看需要实例化哪个对象
            Operation operation = OperationFactory.createOperation(type);

            System.out.println("请输入数字 A：");
            Scanner scanner_num1 = new Scanner(System.in);
            double num1 = scanner_num1.nextInt();
            System.out.println("请输入数字 B：");
            Scanner scanner_num2 = new Scanner(System.in);
            double num2 = scanner_num2.nextInt();

            operation.setNum1(num1);
            operation.setNum2(num2);
            double result = operation.GetResult();

            System.out.println("结果是：" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("您输入的数据有误");
        }

    }
}
