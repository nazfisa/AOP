package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        Account account = new Account();
        theAccountDAO.addAccount(account, true);
        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setName("silver");

        theAccountDAO.getName();
        theAccountDAO.getService();

        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();
        context.close();
    }
}
