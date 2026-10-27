public class Expense {
    private int valueInCents;
    private String category;
    private String description;

    public Expense(int valueInCents, String category, String description) {
        this.valueInCents = valueInCents;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return String
        .format("{'value': %.2f, 'category': '%s', 'description': '%s'}",
                this.valueInCents / 100.0,
                this.category,
                this.description);
    }

    public int getValueInCents() {
        return this.valueInCents;
    }

    public String getCategory() {
        return this.category;
    }
}
