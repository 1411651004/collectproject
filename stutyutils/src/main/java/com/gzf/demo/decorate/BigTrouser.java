package com.gzf.demo.decorate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigTrouser extends Finery {
    Logger log = LoggerFactory.getLogger(BigTrouser.class);

    @Override
    public void Show() {
        log.info("垮裤");
        super.Show();
    }
}
