package com.gzf.demo.text;

import java.util.ArrayList;
import java.util.List;

public class Mianshi {
    public static void main(String[] args) {
        java.util.Stack<String> strStack=new java.util.Stack<String>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.stream().filter(param -> (int)param % 2 == 1)
                .forEach(System.out::print);
    }


    boolean match(String str){
        java.util.Stack<String> strStack=new java.util.Stack<>();
        char[] ch = str.toCharArray();
        int flag =1;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='{'||ch[i]=='('||ch[i]=='[')
                strStack.push( ""+ch[i]);
            else{
                if(strStack.empty()==true){
                    flag=0;
                    break;
                }
                else if((ch[i]=='}'&&strStack.peek().equals('{'))||
                        (ch[i]==')'&&strStack.peek().equals('('))||
                        (ch[i]==']'&&strStack.peek().equals('[')))
                    strStack.pop();
                else{
                    flag = 0;
                    break;
                }
            }
        }
        if(flag==0)
            return true;
        else
            return false;
    }

}
