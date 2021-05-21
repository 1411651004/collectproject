package com.gzf.demo.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @program: demoList
 * @description: lambda中方法的引用
 * @author: Gaozf
 * @create: 2020-03-11 17:47
 **/
public class Method {
    Person p = new Person("", "", 1);

    public static void main(String[] args) {
        //存储person对象的列表
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().name("tom").gender("男").age(16).build());
        personList.add(Person.builder().name("jerry").gender("女").age(15).build());
        personList.add(Person.builder().name("shuke").gender("男").age(30).build());
        personList.add(Person.builder().name("beita").gender("女").age(26).build());
        personList.add(Person.builder().name("damu").gender("男").age(32).build());

        //排序
        /**
         * 1、匿名内部类的方式
         */
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(personList);
        /**
         * lambda表达式的实现
         */
        personList.sort(Comparator.comparingInt(Person::getAge));
        System.out.println(personList);
        /**
         * 3、静态方法引用
         */
        Collections.sort(personList, Person::compareByAge);
        System.out.println(personList);
        /**
         * 4、实例方法的引用
         */
        PersonUtil pu = new PersonUtil();
        Collections.sort(personList, pu::compareByName);
        /**
         * 5、构造方法引用
         */
        IPerson p = Person::new;
        Person person = p.initPerson("gzf", "男", 25);
    }
}

/**
 * 1、静态方法的使用：
 *  类型名称.方法名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Person{
    private String name;
    private String gender;
    private int age;

    public static int compareByAge(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}

class PersonUtil{
    //增加一个方法
    public int compareByName(Person person1,Person person2) {
        return person1.getName().hashCode() - person2.getName().hashCode();
    }
}

interface IPerson {
    //抽象方法：通过制定类型的构造方法初始化数据
    Person initPerson(String name,String gender,int age);
}