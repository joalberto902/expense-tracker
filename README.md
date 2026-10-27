# expense-tracker

A command-line expense tracker written in plain Java, with no external dependencies. It lets you record expenses, list them and see the total spent per category.

## Features

- Interactive menu loop in the terminal
- Add an expense (value, category and description)
- List all expenses
- Show the total per category, sorted alphabetically
- Input validation with clear messages and automatic re-prompting

## Requirements

- JDK 21 or newer (developed and tested with Temurin)

## Getting started

```bash
git clone https://github.com/joalberto902/expense-tracker.git
cd expense-tracker/src
javac *.java
java Main
```

## Usage

```
####################
1 - Add Expense
2 - List Expenses
3 - Totals by category
0 - Exit
####################
```

Example session:

```
1
Enter value in cents: 500
Enter category: fuel
Enter description: new car
Expense added successfully.
```

```
3
food: 62.50
fuel: 105.00
```

Values are typed in **cents** (`1250` means `12.50`).

### Validation

- The value must be a whole number greater than zero.
- The category is required and cannot be blank.
- Invalid input shows a message and asks again, instead of crashing.

## Project structure

```
src/
  Main.java             console menu and user input
  Expense.java          immutable expense model, validates itself on creation
  ExpenseTracker.java   holds the expenses and computes totals per category
```

## Design notes

- **Money is stored as integer cents** to avoid the rounding errors of floating-point numbers. It is converted to a decimal value only for display.
- **`Expense` is immutable and validates itself.** Its fields are private, there are no setters, and the constructor throws `IllegalArgumentException` for invalid data, so an invalid expense can never exist.
- **`ExpenseTracker` owns its data.** The list of expenses is private, and callers receive a read-only copy (`List.copyOf`) or a computed result, never the internal list.

## Limitations

- Expenses are kept in memory only and are lost when the program exits.
- Three sample expenses are added at startup.

## Roadmap

- [ ] Persist expenses to a file
- [ ] Unit tests with JUnit
- [ ] Build with Maven
- [ ] Remove the sample data from startup
