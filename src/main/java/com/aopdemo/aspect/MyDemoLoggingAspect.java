package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    @Before("com.aopdemo.aspect.CommonAspect.daoPackageNoGetterSetter()")
    public void addBeforeAccount(JoinPoint joinPoint){
        System.out.println("Executing ===> before advice on account");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object argument: args) {
            System.out.println(argument);

            if(argument instanceof Account){
                Account account = (Account) argument;
                System.out.println("Account name : "+ account.getName());
                System.out.println("Level Name: "+account.getLevel());
            }
        }
    }


}
