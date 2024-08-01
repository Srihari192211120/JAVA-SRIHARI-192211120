import java.util.Scanner;

abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds to withdraw $" + amount);
        }
        printBalance();
    }

    public void printBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }

    public abstract void applyMonthlyInterestOrFees();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void applyMonthlyInterestOrFees() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Monthly interest applied: $" + interest);
        printBalance();
    }
}

class CheckingAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;
    private static final double FEE = 50;

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void applyMonthlyInterestOrFees() {
        if (balance < MIN_BALANCE) {
            balance -= FEE;
            System.out.println("Fee charged: $" + FEE);
        }
        printBalance();
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < MIN_BALANCE) {
            System.out.println("Balance below minimum. Applying fee.");
            balance -= FEE;
            printBalance();
        }
    }
}

public class BankAccount_java2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create a Savings Account or Checking Account? (Enter S for Savings, C for Checking)");
        String accountType = scanner.nextLine();

        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter initial balance:");
        double balance = scanner.nextDouble();

        BankAccount account;
        if (accountType.equalsIgnoreCase("S")) {
            account = new SavingsAccount(accountNumber, balance);
        } else if (accountType.equalsIgnoreCase("C")) {
            account = new CheckingAccount(accountNumber, balance);
        } else {
            System.out.println("Invalid account type. Exiting program.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Apply Monthly Interest/Fees");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.printBalance();
                    break;
                case 4:
                    account.applyMonthlyInterestOrFees();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}