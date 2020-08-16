package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (Finally) on method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);

    }

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
