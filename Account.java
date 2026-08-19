public class Account {
    int accountId;
    String name;
    double balance;
    Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully!");
        }
        else {
            System.out.println("Invalid amount.");
        }
    }
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }
    void displayBalance() {
        System.out.println("Account ID : " + accountId);
        System.out.println("Name       : " + name);
        System.out.println("Balance    : Rs." + balance);
    }
}
