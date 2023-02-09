package com.basic.myspringboot;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener implements ApplicationListener<ApplicationStartingEvent>{
    public void onApplicationEvent(ApplicationStartingEvent arg0) {
        System.out.println("=========================");
        System.out.println("Application is Starting");
        System.out.println("=========================");
    }
    public void onApplicationEvent(ApplicationStartedEvent arg0) {
        System.out.println("==========================");
        System.out.println("Application is Started");
        System.out.println("==========================");
    }

}
