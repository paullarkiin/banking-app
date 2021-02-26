package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        int choice;
        int nextChoice;

        Scanner scanner = new Scanner(System.in);

        StandardAccount account1 = new StandardAccount(1, 20.00);
        LimitedAccount lAccount1 = new LimitedAccount(2, 20.00);

        do {
            System.out.println(" --- Bank Accounts --- ");
            System.out.println("What type of account do you want to use today? ");
            System.out.println("1. Standard Account");
            System.out.println("2. Limited Account");
            System.out.println("3. Quit");
            System.out.print("Enter: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    double amount;
                    System.out.println("What account action would like to perform today? ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");
                    System.out.print("Enter: ");

                    nextChoice = scanner.nextInt();


                    if (nextChoice == 1) {

                        System.out.println("Enter amount to be Deposited: ");
                        amount = scanner.nextDouble();
                        account1.deposit(amount);
                        System.out.println();

                    } else if (nextChoice == 2) {

                        System.out.println("Enter amount to be Withdraw: ");
                        amount = scanner.nextDouble();
                        account1.withdraw(amount);
                        System.out.println();

                    } else if (nextChoice == 3) {

                        System.out.println(account1.getBalance());
                        System.out.println();

                    } else if (nextChoice == 4) {
                        System.out.println("Bye");
                        System.exit(0);

                    } else {
                        System.out.println("Error: Please select an option between 1 - 4 and try again!");
                    }

                case 2:
                    System.out.println("What account action would like to perform today? ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Check Balance");
                    System.out.println("4. Exit");
                    System.out.print("Enter: ");

                    nextChoice = scanner.nextInt();


                    if (nextChoice == 1) {

                        System.out.println("Enter amount to be Deposited: ");
                        amount = scanner.nextDouble();
                        lAccount1.deposit(amount);
                        System.out.println();

                    } else if (nextChoice == 2) {

                        System.out.println("Enter amount to be Withdraw: ");
                        amount = scanner.nextDouble();
                        lAccount1.withdraw(amount);
                        System.out.println();

                    } else if (nextChoice == 3) {

                        System.out.println(lAccount1.getBalance());
                        System.out.println();

                    } else if (nextChoice == 4) {
                        saveDetails(account1, lAccount1);
                        System.out.println("Bye");
                        System.exit(0);

                    } else {
                        System.out.println("Error: Please select an option between 1 - 4 and try again!");
                    }

                case 3:
                    saveDetails(account1, lAccount1);
                    break;
            }
        }
        while (choice != 3);
    }


    public static void saveDetails(StandardAccount standardAccount, LimitedAccount limitedAccount) {

        // writes to csv
        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
            StringBuilder sb = new StringBuilder();

            sb.append("id");
            sb.append(',');
            sb.append("Balance");
            sb.append('\n');

            sb.append(standardAccount.getId());
            sb.append(',');
            sb.append(standardAccount.getBalance());
            sb.append('\n');

            sb.append(limitedAccount.getId());
            sb.append(',');
            sb.append(limitedAccount.getBalance());
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("Done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}