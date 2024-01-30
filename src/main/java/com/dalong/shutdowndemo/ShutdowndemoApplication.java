package com.dalong.shutdowndemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

@SpringBootApplication
public class ShutdowndemoApplication {
    private  static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext= SpringApplication.run(ShutdowndemoApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down");
            MyEvent myEvent = new MyEvent("1.0.0");
            myEvent.setName("dalong");
            myEvent.setVersion("1.0.0");
            applicationContext.publishEvent(myEvent);
        } ));
    }

}
