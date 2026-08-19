import java.util.ArrayList;
import java.util.Scanner;
public class BankManagement {
    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Account findAccount(int accountId) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountId == accountId) {
                return accounts.get(i);
            }
        }
        return null;
    }
    static void createAccount() {
        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).accountId == accountId) {
                System.out.println("Account ID already exists!");
                return;
            }
        }
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();
        if (balance < 0) {
            System.out.println("Invalid initial deposit.");
            return;
        }
        Account account = new Account(accountId, name, balance);
        accounts.add(account);
        System.out.println("Account created successfully!");
      
    static void depositMoney() {
        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }
    static void withdrawMoney() {
        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        System.out.print("Enter Withdrawal Amount: ");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
    static void checkBalance() {
        System.out.print("Enter Account ID: ");
        int accountId = sc.nextInt();
        Account account = findAccount(accountId);
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        account.displayBalance();
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using Bank Management System!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
