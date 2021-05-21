package com.gzf.demo.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TShirts extends Finery {
    Logger log = LoggerFactory.getLogger(TShirts.class);
    @Override
    public void Show() {
        log.info("大T恤");
        super.Show();
    }
}
