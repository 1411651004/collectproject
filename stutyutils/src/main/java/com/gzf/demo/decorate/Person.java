package com.gzf.demo.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person {
    Logger log = LoggerFactory.getLogger(Person.class);
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void Show(){
        log.info("装扮的{}",name);
    }
}
