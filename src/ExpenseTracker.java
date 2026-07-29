import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== Expense Tracker ==========");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transaction History");
            System.out.println("4. Daily Report");
            System.out.println("5. Monthly Report");
            System.out.println("6. Yearly Report");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTransaction(TransactionType.INCOME);
                    break;

                case 2:
                    addTransaction(TransactionType.EXPENSE);
                    break;

                case 3:
                    viewTransactions();
                    break;

                case 4:
                    dailyReport();
                    break;

                case 5:
                    monthlyReport();
                    break;

                case 6:
                    yearlyReport();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

    }

    static void addTransaction(TransactionType type) {

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        LocalDate date = LocalDate.now();

        transactions.add(new Transaction(amount, category, type, date));

        System.out.println(type + " Added Successfully.");
    }

    static void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No Transactions Found.");
            return;
        }

        System.out.println("\n------ Transaction History ------");

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    static void dailyReport() {

        LocalDate today = LocalDate.now();

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.getDate().equals(today)) {

                if (t.getType() == TransactionType.INCOME)
                    income += t.getAmount();
                else
                    expense += t.getAmount();
            }
        }

        System.out.println("\n------ Daily Report ------");
        System.out.println("Income : ₹" + income);
        System.out.println("Expense: ₹" + expense);
        System.out.println("Balance: ₹" + (income - expense));
    }

    static void monthlyReport() {

        LocalDate today = LocalDate.now();

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.getDate().getMonth() == today.getMonth()
                    && t.getDate().getYear() == today.getYear()) {

                if (t.getType() == TransactionType.INCOME)
                    income += t.getAmount();
                else
                    expense += t.getAmount();
            }
        }

        System.out.println("\n------ Monthly Report ------");
        System.out.println("Income : ₹" + income);
        System.out.println("Expense: ₹" + expense);
        System.out.println("Balance: ₹" + (income - expense));
    }

    static void yearlyReport() {

        int year = LocalDate.now().getYear();

        double income = 0;
        double expense = 0;

        for (Transaction t : transactions) {

            if (t.getDate().getYear() == year) {

                if (t.getType() == TransactionType.INCOME)
                    income += t.getAmount();
                else
                    expense += t.getAmount();
            }
        }

        System.out.println("\n------ Yearly Report ------");
        System.out.println("Income : ₹" + income);
        System.out.println("Expense: ₹" + expense);
        System.out.println("Balance: ₹" + (income - expense));
    }
}