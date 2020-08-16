package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalytics {
    @Before("com.aopdemo.aspect.CommonAspect.daoPackageNoGetterSetter()")
    public void apiAnalytics(){
        System.out.println("Executing ===> before advice on API");
    }
}
