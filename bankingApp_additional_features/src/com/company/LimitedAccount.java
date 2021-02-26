package com.company;

public class LimitedAccount extends StandardAccount {

    public LimitedAccount(int id, double balance){
        super(id, balance);
    }

    public void deposit(double amount)
    {
        if(amount > 50.00)
        {
            System.out.println("You have gone over deposit your limit");
            System.out.println("Please enter an amount less than £50 and try again!");
        }
        else
        {
            super.deposit(amount);
        }
    }

    public void withdraw(double amount)
    {
        if(amount > 100)
        {
            System.out.println("You have gone over withdraw limit");
            System.out.println("Please enter an amount less than £100 and try again!");
        }else{
            super.withdraw(amount);
        }
    }

}
