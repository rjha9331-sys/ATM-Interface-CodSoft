import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Class representing the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("🏧 Welcome to the ATM");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please select 1-4.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("💰 Current Balance: ₹%.2f\n", account.checkBalance());
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.printf("✅ Successfully deposited ₹%.2f\n", amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.printf("✅ Successfully withdrew ₹%.2f\n", amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }
}

// Main class to run the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        // Starting balance set to ₹10,000
        BankAccount userAccount = new BankAccount(10000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
