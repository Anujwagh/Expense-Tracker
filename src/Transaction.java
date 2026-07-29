import java.time.LocalDate;

public class Transaction {

    private double amount;
    private String category;
    private TransactionType type;
    private LocalDate date;

    public Transaction(double amount, String category, TransactionType type, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Date: " + date +
                " | Type: " + type +
                " | Category: " + category +
                " | Amount: ₹" + amount;
    }
}