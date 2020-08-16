package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println(getClass()+": Add Stuff: ADDING an membership account");
    }
    public void goToSleep(){
        System.out.println(getClass()+": goto Sleep");
    }
}
