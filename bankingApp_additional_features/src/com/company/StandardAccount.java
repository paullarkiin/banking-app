package com.company;

import java.io.Serializable;

public class StandardAccount implements Serializable {

    private double balance;
    private int id;
    private static final double OVERDRAFT = -100;

    public StandardAccount() {
        balance = 0.00;
        id = 0;
    }

    public StandardAccount(int id, double balance) {
        this.balance = balance;
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.printf("You now have a balance of: £ %.2f\n", balance);

    }

    public void withdraw(double amount) {

        if (balance - amount < OVERDRAFT) {
            System.out.println("You have exceeded your overdraft limit");
        } else {
            balance = balance - amount;
            if (balance < 0) {
                System.out.println("\nYour account is entering an overdraft...");
            }
            System.out.printf("You now have a balance of: £ %.2f\n", balance);
        }

    }
}
