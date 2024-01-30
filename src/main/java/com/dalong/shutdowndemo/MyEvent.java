package com.dalong.shutdowndemo;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private String name;
    private String version;

    public MyEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
