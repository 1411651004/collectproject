package com.gzf.demo.decorate;

/**
 * 定义一个服饰接口
 */
public class Finery extends Person {
    protected  Person component;
    public void Decorate(Person component){
        this.component = component;
    }
    public void Show(){
        if (component!=null){
            component.Show();
        }
    }
}
