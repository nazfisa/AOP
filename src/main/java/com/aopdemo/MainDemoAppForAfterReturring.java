package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoAppForAfterReturring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        List<Account> myAccounts = theAccountDAO.findAccounts(false);

        System.out.println("Main Programme");
        System.out.println(myAccounts);
        context.close();
    }
}
