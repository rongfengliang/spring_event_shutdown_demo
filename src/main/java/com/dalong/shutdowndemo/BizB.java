package com.dalong.shutdowndemo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Service;

@Service
public class BizB  implements ApplicationListener<ContextClosedEvent> {
    public String doBiz() {
        try {
            System.out.println("doBizB biz start");
            Thread.sleep(4000);
            System.out.println("doBizB biz end");
            return "doBizB biz end";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  String actionB(){
        return "actionB";
    }
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("BizB onApplicationEvent Shutting down");
        doBiz();
    }
}
