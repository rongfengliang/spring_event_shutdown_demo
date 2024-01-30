package com.dalong.shutdowndemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

@Service
public class BizA implements ApplicationListener<ContextClosedEvent> {
    public String doBiz() {
        try {
            System.out.println("doBizA biz start");
            Thread.sleep(6000);
            System.out.println("doBizA biz end");
            return "doBizA biz end";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String acitonA() {
        return "actionA";
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("BizA onApplicationEvent Shutting down");
        doBiz();
    }
}
