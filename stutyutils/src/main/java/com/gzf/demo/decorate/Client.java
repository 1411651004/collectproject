package com.gzf.demo.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Client.class);

        Person person = new Person("高振芳");
        log.info("第一种装扮：");
        WearShoes wearShoes = new WearShoes();
        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();
        wearShoes.Decorate(person);
        bigTrouser.Decorate(wearShoes);
        tShirts.Decorate(bigTrouser);
        tShirts.Show();


    }
}
