package com.gzf.demo.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WearShoes extends Finery{
    Logger log = LoggerFactory.getLogger(WearShoes.class);

    @Override
    public void Show() {
        log.info("破球鞋");
        super.Show();
    }
}
