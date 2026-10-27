import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        
        tracker.addExpense(new Expense(1250, "food", "daily food"));
        tracker.addExpense(new Expense(5000, "food", "weekend out"));
        tracker.addExpense(new Expense(10000, "fuel", "weekly gasoline"));

        Scanner scanner = new Scanner(System.in);

        int value;
        while (true) {
            try {
                System.out.print("Enter value in cents: ");
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again");
            }
        }

        System.out.printf("valueInCents: %d%n", value);

        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.printf("category: %s%n", category);
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.printf("description: %s%n", description);

        tracker.addExpense(new Expense(value, category, description));

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
