package BankingSystems;

// A simple Account class for beginners
public class Account {
    // Fields to store account information
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Creates a new account
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

public String getAccountNumber() {
    return accountNumber;
}
    // Deposits money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Please enter a positive amount to deposit.");
        }
    }

    // Withdraws money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("You do not have enough balance to withdraw " + amount);
        } else {
            System.out.println("Please enter a positive amount to withdraw.");
        }
    }

    // Checks the current balance
    public double getBalance() {
        return balance;
    }

    // Displays account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}