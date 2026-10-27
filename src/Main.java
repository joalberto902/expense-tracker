import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        
        tracker.addExpense(new Expense(1250, "food", "daily food"));
        tracker.addExpense(new Expense(5000, "food", "weekend out"));
        tracker.addExpense(new Expense(10000, "fuel", "weekly gasoline"));
        
        for (Expense e: tracker.getExpenseList()) {
            System.out.println(e);
        }

        Map<String, Integer> categoryTotals = tracker.getCategoryTotals();

        for (Map.Entry<String, Integer> entry: categoryTotals.entrySet()) {
            System.out.printf(
                "%s: %.2f%n",
                entry.getKey(),
                entry.getValue() / 100.0
            );
        }
    }
}
