package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        StandardAccount standardAccount = new StandardAccount(1, 20.00);
        LimitedAccount limitedAccount = new LimitedAccount(2, 20.00);


        try {

            // Reads saved .dat file and append it to new object.
            FileInputStream fis = new FileInputStream("standardAccount.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            standardAccount = (StandardAccount) ois.readObject();
            ois.close();

            FileInputStream Fis = new FileInputStream("limitedAccount.dat");
            ObjectInputStream Ois = new ObjectInputStream(Fis);
            limitedAccount = (LimitedAccount) Ois.readObject();
            Ois.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }


        int choice;
        int nextChoice;

        Scanner scanner = new Scanner(System.in);

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
                        scanner.nextLine();
                        System.out.println("Enter amount to be Deposited: ");
                        amount = scanner.nextDouble();
                        standardAccount.deposit(amount);
                        System.out.println();

                    } else if (nextChoice == 2) {
                        System.out.println("Enter amount to be Withdraw: ");
                        scanner.nextLine();
                        amount = scanner.nextDouble();
                        standardAccount.withdraw(amount);
                        System.out.println();

                    }else if(nextChoice == 3) {
                        System.out.printf("You now have a balance of: £ %.2f\n", standardAccount.getBalance());
                        System.out.println();

                    }else if (nextChoice == 4) {
                        System.out.println("Bye");
                        System.exit(0);

                    } else {
                        System.out.println("Error: Please select an option between 1 - 4 and try again!");
                    }
                    break;

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
                        limitedAccount.deposit(amount);
                        System.out.println();

                    } else if (nextChoice == 2) {
                        scanner.nextLine();
                        System.out.println("Enter amount to be Withdraw: ");
                        amount = scanner.nextDouble();
                        limitedAccount.withdraw(amount);
                        System.out.println();

                    } else if(nextChoice == 3)
                    {
                        System.out.printf("You now have a balance of: £ %.2f\n", limitedAccount.getBalance());

                    } else if (nextChoice == 4) {
                        saveObjects(standardAccount, limitedAccount);
                        System.out.println("Bye");
                        System.exit(0);

                    } else {
                        System.out.println("Error: Please select an option between 1 - 4 and try again!");
                    }

                case 3:
                    saveObjects(standardAccount, limitedAccount);
                    break;
            }
        }
        while (choice != 3);
    }

    public static void saveObjects(StandardAccount standardAccount, LimitedAccount limitedAccount) throws IOException {
        FileOutputStream fos = new FileOutputStream("standardAccount.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(standardAccount);
        oos.close();

        FileOutputStream Fos = new FileOutputStream("limitedAccount.dat");
        ObjectOutputStream Oos = new ObjectOutputStream(Fos);
        Oos.writeObject(limitedAccount);
        Oos.close();
    }
}