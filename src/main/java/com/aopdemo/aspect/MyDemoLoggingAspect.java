package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){
    String method = joinPoint.getSignature().toShortString();
        System.out.println("===> AfterReturning : "+method);
        System.out.println("===>Result: "+result);
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);
    }
    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts

        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);
        }

    }





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
