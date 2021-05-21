package com.gzf.demo.proxy;

public class Client {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl();
        jiaojiao.setName("李娇娇");
        Pursuit zhuojiayi1 = new Pursuit(jiaojiao);

        zhuojiayi1.GiveChocolate();
        zhuojiayi1.GiveDolls();
        zhuojiayi1.GiveFlowers();
    }
}
