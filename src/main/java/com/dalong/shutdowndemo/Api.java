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


    @Autowired
    private BizC bizC;

    @GetMapping(value = {"/demo"})
    public String demo() {
        String a = bizA.acitonA();
        String b = bizB.actionB();
        String c = bizC.actionC();
        return a + b + c;
    }
}
