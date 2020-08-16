package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoAppForAround {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        System.out.println("Calling fortune service");
        String data = trafficFortuneService.getFortune();
        System.out.println("Fortune service data: "+data);
        System.out.println("finished");
        context.close();
    }
}
