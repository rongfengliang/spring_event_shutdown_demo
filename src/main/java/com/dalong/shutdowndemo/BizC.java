package com.dalong.shutdowndemo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BizC implements ApplicationListener<MyEvent> {

    public String bizC() {
        try {
            System.out.println("bizC biz start");
            Thread.sleep(2000);
            System.out.println("bizC biz end");
            return "bizC biz end";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("BizC onApplicationEvent Shutting down");
        System.out.println(event.getVersion());
        bizC();
    }
}
