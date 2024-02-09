package com.dalong.shutdowndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api implements ApplicationListener<ContextClosedEvent> {

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

    private void doClean() {
        try {
            System.out.println("Api doClean start");
            Thread.sleep(3000);
            System.out.println("Api doClean end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Api onApplicationEvent Shutting down");
        doClean();
    }
}
