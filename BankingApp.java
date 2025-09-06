package BankingSystems;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*** Banking Management System ***");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Print Cheque/Pay Slip");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initBalance = scanner.nextDouble();
                    scanner.nextLine();
                    bank.addAccount(new Account(accNum, name, initBalance));
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    Account account = bank.findAccount(accNum);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    account = bank.findAccount(accNum);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        account.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    account = bank.findAccount(accNum);
                    if (account != null) {
                        System.out.println("Current balance: " + account.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accNum = scanner.nextLine();
                    account = bank.findAccount(accNum);
                    if (account != null) {
                        account.displayAccountDetails();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter cheque amount: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter payee name: ");
                    String payee = scanner.nextLine();
                    cheque.PrintCheque(amount, payee);
                    break;

                case 7:
                    System.out.println("Thank you for using the Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
