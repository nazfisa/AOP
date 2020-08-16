package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String service;


    public void addAccount(Account theAccount, boolean vipPerson){
        System.out.println(getClass()+": Doing my DB work: ADDING an account");
    }

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        Account account = new Account("asif","silver");
        Account account2 = new Account("nazim","platinum");
        Account account3 = new Account("nizam","gold");

        myAccounts.add(account);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }
    public boolean doWork(){
        System.out.println(getClass()+": do work");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+" getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" setName");
        this.name = name;
    }

    public String getService() {
        System.out.println(getClass()+" getService");
        return service;
    }

    public void setService(String service) {
        System.out.println(getClass()+" setService");
        this.service = service;
    }
}
