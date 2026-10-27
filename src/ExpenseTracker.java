import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

public class ExpenseTracker {
    private List<Expense> expenseList = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public Map<String, Integer> getCategoryTotals() {
        Map<String, Integer> categoryTotals = new TreeMap<>();
        for (Expense e: this.expenseList) {
            categoryTotals.put(
                e.getCategory(),
                categoryTotals.getOrDefault(e.getCategory(), 0) + e.getValueInCents()
            );
        }

        return categoryTotals;
    }

    public List<Expense> getExpenseList() {
        return List.copyOf(this.expenseList);
    }
}
