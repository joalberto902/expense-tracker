import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Expense> expenseList = new ArrayList<Expense>();
        
        expenseList.add(new Expense(1250, "food", "daily food"));
        expenseList.add(new Expense(5000, "food", "weekend out"));
        expenseList.add(new Expense(10000, "fuel", "weekly gasoline"));

        for (Expense e: expenseList) {
            System.out.println(e);
        }
    }
}
