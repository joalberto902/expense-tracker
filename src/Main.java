import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        
        tracker.addExpense(new Expense(1250, "food", "daily food"));
        tracker.addExpense(new Expense(5000, "food", "weekend out"));
        tracker.addExpense(new Expense(10000, "fuel", "weekly gasoline"));

        Scanner scanner = new Scanner(System.in);

        boolean shouldExit = false;
        do {
            printMenu();
            String opt = scanner.nextLine();
            
            switch (opt) {
                case "1" -> {
                    addExpense(scanner, tracker);
                }
                case "2" -> {
                    listExpenses(tracker);
                }
                case "3" -> {
                    categoryTotals(tracker);
                }
                case "0" -> shouldExit = true;
                default -> {
                    System.out.println("invalid option, please try again.");
                }
            }
        }
        while (!shouldExit);

        System.out.println("Exiting....");
    }

    private static void printMenu() {
        String divisor = "#";
        System.out.println(divisor.repeat(20));
        System.out.printf(
            "1 - Add Expense%n2 - List Expenses%n3 - Totals by category%n0 - Exit%n"
        );
        System.out.println(divisor.repeat(20));
    }

    private static int readValue(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter value in cents: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again");
            }
        }
    }

    private static void addExpense(Scanner scanner, ExpenseTracker tracker) {
        while (true) {
            try {
                int value = readValue(scanner);
                System.out.printf("valueInCents: %d%n", value);

                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.printf("category: %s%n", category);
                
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.printf("description: %s%n", description);

                tracker.addExpense(new Expense(value, category, description));
                System.out.println("Expense added successfully.");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void listExpenses(ExpenseTracker tracker) {
        for (Expense exp: tracker.getExpenseList()) {
            System.out.println(exp);
        }
    }

    private static void categoryTotals(ExpenseTracker tracker) {
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
