package com.gzf.demo.proxy;

/**
 * 追求者类
 */
public class Pursuit {
    SchoolGirl schoolGirl;

    public SchoolGirl getSchoolGirl() {
        return schoolGirl;
    }

    public void setSchoolGirl(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }
    public void GiveDolls(){
        System.out.println(schoolGirl.getName()+"送你洋娃娃");
    }
    public void GiveFlowers(){
        System.out.println(schoolGirl.getName()+"送你鲜花");
    }
    public void GiveChocolate(){
        System.out.println(schoolGirl.getName()+"送你巧克力");
    }
}
