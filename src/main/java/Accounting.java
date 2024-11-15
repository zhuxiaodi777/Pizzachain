import java.util.ArrayList;
import java.util.List;

/**
 * Represents the accounting department in a store,
 * responsible for tracking revenue, costs, and expenses.
 */
class Accounting {
	private double totalRevenue;
	private double totalCost;
	private double profit;
	private List<Double> expenses;
	private List<Double> revenueHistory;
	private List<String> expenseDescriptions;

	// Default constructor
	public Accounting() {
		this.expenses = new ArrayList<>();
		this.revenueHistory = new ArrayList<>();
		this.expenseDescriptions = new ArrayList<>();
	}

	// Constructor with initial values
	public Accounting(double totalRevenue, double totalCost) {
		this();
		this.totalRevenue = totalRevenue;
		this.totalCost = totalCost;
		calculateProfit();
	}

	// Method to calculate profit
	public void calculateProfit() {
		this.profit = totalRevenue - totalCost - calculateTotalExpenses();
	}

	/**
	 * Adds a revenue entry and recalculates profit.
	 * @param revenue The revenue to be added
	 */
	public void addRevenue(double revenue) {
		if (revenue < 0) {
			throw new IllegalArgumentException("Revenue cannot be negative");
		}
		totalRevenue += revenue;
		revenueHistory.add(revenue);
		calculateProfit();
	}

	/**
	 * Adds an expense entry and recalculates profit.
	 * @param expense The expense amount
	 * @param description Description of the expense
	 */
	public void addExpense(double expense, String description) {
		if (expense < 0) {
			throw new IllegalArgumentException("Expense cannot be negative");
		}
		expenses.add(expense);
		expenseDescriptions.add(description);
		calculateProfit();
	}

	/**
	 * Calculates the total of all expenses.
	 * @return Total expenses
	 */
	private double calculateTotalExpenses() {
		double total = 0;
		for (Double expense : expenses) {
			total += expense;
		}
		return total;
	}

	/**
	 * Generates a summary report of revenue and expenses.
	 * @return String containing the report
	 */
	public String generateReport() {
		StringBuilder report = new StringBuilder("Accounting Report:\n");
		report.append("Total Revenue: $").append(totalRevenue).append("\n");
		report.append("Total Cost: $").append(totalCost).append("\n");
		report.append("Total Expenses: $").append(calculateTotalExpenses()).append("\n");
		report.append("Profit: $").append(profit).append("\n\n");

		report.append("Revenue History:\n");
		for (Double revenue : revenueHistory) {
			report.append("$").append(revenue).append("\n");
		}

		report.append("\nExpenses:\n");
		for (int i = 0; i < expenses.size(); i++) {
			report.append("Expense: $").append(expenses.get(i))
					.append(" - ").append(expenseDescriptions.get(i))
					.append("\n");
		}

		return report.toString();
	}

	// Getter and Setter methods
	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
		calculateProfit();
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
		calculateProfit();
	}

	public double getProfit() {
		return profit;
	}

	public List<Double> getExpenses() {
		return expenses;
	}

	/**
	 * Method to check if the store is profitable.
	 * @return True if profitable, false otherwise
	 */
	public boolean isProfitable() {
		return profit > 0;
	}

	/**
	 * Calculates the average monthly revenue based on revenue history.
	 * Assumes revenue entries are recorded monthly.
	 * @return Average monthly revenue
	 */
	public double calculateAverageMonthlyRevenue() {
		if (revenueHistory.isEmpty()) {
			return 0;
		}
		double total = 0;
		for (double revenue : revenueHistory) {
			total += revenue;
		}
		return total / revenueHistory.size();
	}

	/**
	 * Resets all accounting data to initial state.
	 */
	public void resetAccounting() {
		totalRevenue = 0;
		totalCost = 0;
		profit = 0;
		expenses.clear();
		revenueHistory.clear();
		expenseDescriptions.clear();
	}
}
