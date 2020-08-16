package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class CommonAspect {
    //@Before("execution(public void addAccount())")
    //@Before("execution(* add*(com.aopdemo.Account,..))")
    //@Before("execution(* com.aopdemo.dao.*.*(..))")
    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter(){}
}
