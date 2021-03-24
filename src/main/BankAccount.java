package main;

import java.util.Scanner;

public class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount(String cname, String cid) {
        this.customerName = cname;
        this.customerId = cid;
    }

    public void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

    public void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);

        do {
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("enter option");
            option = sc.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("Balance " + balance);
                    break;
                case 'B':
                    System.out.println("Enter amount to deposit");
                    int amount = sc.nextInt();
                    deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter amount to withdraw:");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("thank you for using our service");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option!!. Please enter again.");
                    break;
            }
        } while (option != 'E');
    }
}
