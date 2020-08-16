package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogInToCloud {
    @Before("com.aopdemo.aspect.CommonAspect.daoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("Executing ===> before advice on Cloud Async");
    }
}
