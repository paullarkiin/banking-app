package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StandardAccount account1 = new StandardAccount(1, 20.00);
        LimitedAccount lAccount1 = new LimitedAccount(2, 20.00);


        account1.deposit(30.00);

        account1.withdraw(10.00);

        account1.withdraw(60.00);
        System.out.println();
        account1.withdraw(105.00);
        System.out.println();

//  -- Test LimitedAccount --

        //standard deposit < 50
        lAccount1.deposit(30.00);

        // standard withdraw < 100
        lAccount1.withdraw(25.00);

        //handles error with deposit limit over £50
        lAccount1.deposit(60.00);

        //handles error with withdraw limit over £100
        lAccount1.withdraw(110);


        // tests overdraft functionally was inherited  and working
        // when over code commented out
        // 20 - 50 - 75 = -105
//        lAccount1.withdraw(50);
//        lAccount1.withdraw(75);


    }

}