package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoAppForAfterThrowing {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        List<Account> myAccounts = null;
        try {
            boolean tripWire = true;
            myAccounts = theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception e){
            System.out.println("\n\n Main programme caught exception "+ e);
        }

        System.out.println("Main Programme");
        System.out.println(myAccounts);
        context.close();
    }
}
