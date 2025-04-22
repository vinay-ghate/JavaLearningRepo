// Bank Account Simulation
// Concepts: Inheritance, Polymorphism, Abstract classes, Exception Handling

// Requirements: Account (abstract), SavingsAccount, CurrentAccount classes. Support deposit, withdraw (with checks).

import java.util.Scanner;

abstract class Account{
    protected  int accountNumber;
    protected  String name;
    protected  int balance;

    public abstract void deposit(int amount);
    public abstract void withdraw(int amount);

    public Account(int accountNumber, String name, int balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void showBalance(){
        System.out.println("Your account balanace is "+balance);
    }

}


class SavingsAccount extends Account {
    
    public SavingsAccount(int accountNumber, String name, int balance){
        super(accountNumber,name,balance);
    }
    
    @Override
    public void deposit(int amount){
        if(amount>0){
            balance+=amount;
        }
        System.out.println("Current Balance :"+balance);
    };

    @Override
    public void withdraw(int amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
        }
        else{
            System.out.println("Invalid Operation");
        }
        System.out.println("Current Balance :"+balance);
    };
}

class CurrentAccount extends Account {
    int MAXBALANE = 5000;
    
    public CurrentAccount(int accountNumber, String name, int balance){
        super(accountNumber,name,balance);
    }
    
    @Override
    public void deposit(int amount){
        if(amount>0){
            balance+=amount;
        }
        System.out.println("Current Balance :"+balance);
    };

    @Override
    public void withdraw(int amount){
        if(amount>0 && amount<=balance){
            balance-=amount;
        }
        else{
            System.out.println("Invalid Operation");
        }
        System.out.println("Current Balance :"+balance);
    };
}


public class BankAccountApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = null;

        System.out.println("Welcome to Simple Bank");
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        int balance = sc.nextInt();

        System.out.print("Account Type (1 for Savings, 2 for Current): ");
        int type = sc.nextInt();

        if (type == 1) {
            acc = new SavingsAccount(accNo, name, balance);
        } else if (type == 2) {
            acc = new CurrentAccount(accNo, name, balance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    acc.deposit(dep);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    int wd = sc.nextInt();
                    acc.withdraw(wd);
                }
                case 3 -> acc.showBalance();
                case 4 -> System.out.println("Thank you for banking with us!");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }
}