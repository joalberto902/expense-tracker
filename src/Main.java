import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        List<Expense> expenseList = new ArrayList<Expense>();
        
        expenseList.add(new Expense(1250, "food", "daily food"));
        expenseList.add(new Expense(5000, "food", "weekend out"));
        expenseList.add(new Expense(10000, "fuel", "weekly gasoline"));
        
        for (Expense e: expenseList) {
            System.out.println(e);
        }

        Map<String, Integer> categoryTotals = new TreeMap<>();
        for (Expense e: expenseList) {
            categoryTotals.put(
                e.getCategory(),
                categoryTotals.getOrDefault(e.getCategory(), 0) + e.getValueInCents()
            );
        }

        for (Map.Entry<String, Integer> entry: categoryTotals.entrySet()) {
            System.out.printf(
                "%s: %.2f%n",
                entry.getKey(),
                entry.getValue() / 100.0
            );
        }
    }
}
