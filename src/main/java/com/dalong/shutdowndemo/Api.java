package com.dalong.shutdowndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @Autowired
    private BizA bizA;

    @Autowired
    private BizB bizB;

    @GetMapping(value = {"/demo"})
    public String demo() {
        String a = bizA.acitonA();
        String b = bizB.actionB();
        return a + b;
    }
}
