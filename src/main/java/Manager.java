import java.util.ArrayList;
import java.util.List;

/**
 * Represents a manager in the system, responsible for overseeing store operations.
 */
class Manager extends Employee {
	private List<Employee> managedEmployees;
	private Store managedStore;

	// Constructor
	public Manager(int id, String name, double salary, String schedule) {
		super(id, name, salary, schedule);
		this.managedEmployees = new ArrayList<>();
	}

	// Assign a store to the manager
	public void manageStore(Store store) {
		this.managedStore = store;
		System.out.println("Manager " + getName() + " is now managing the store at " + store.getLocation());
	}

	// Approve the schedule for employees
	public void approveSchedule(Employee employee, String newSchedule) {
		employee.setSchedule(newSchedule);
		System.out.println("Schedule approved for employee " + employee.getName());
	}

	// Add an employee to the manager's team
	public void addEmployee(Employee employee) {
		managedEmployees.add(employee);
		System.out.println("Employee " + employee.getName() + " added to manager " + getName() + "'s team.");
	}

	// Remove an employee from the manager's team
	public void removeEmployee(Employee employee) {
		managedEmployees.remove(employee);
		System.out.println("Employee " + employee.getName() + " removed from manager " + getName() + "'s team.");
	}

	// Evaluate employee performance based on feedback
	public void evaluatePerformance(Employee employee, List<Feedback> feedbackList) {
		int positiveCount = 0;
		int negativeCount = 0;

		for (Feedback feedback : feedbackList) {
			if (feedback.isPositiveFeedback()) {
				positiveCount++;
			} else {
				negativeCount++;
			}
		}

		System.out.println("Performance Evaluation for " + employee.getName() + ":");
		System.out.println("Positive Feedback: " + positiveCount);
		System.out.println("Negative Feedback: " + negativeCount);

		if (positiveCount > negativeCount) {
			System.out.println(employee.getName() + " is performing well.");
		} else {
			System.out.println(employee.getName() + " needs improvement.");
		}
	}

	// Check inventory levels in the store
	public void checkInventory() {
		if (managedStore != null) {
			System.out.println("Checking inventory for store at " + managedStore.getLocation() + "...");
			for (Item item : managedStore.getMenu().getMenuItems()) {
				System.out.println("Item: " + item.getName() + " - Availability: " + (item.isAvailable() ? "In stock" : "Out of stock"));
			}
		} else {
			System.out.println("Manager " + getName() + " is not assigned to any store.");
		}
	}

	// Arrange shifts for employees
	public void arrangeShift(Employee employee, String shiftTime) {
		employee.setSchedule(shiftTime);
		System.out.println("Shift arranged for employee " + employee.getName() + " at " + shiftTime);
	}

	// Generate a report of managed employees
	public void generateEmployeeReport() {
		System.out.println("Employee Report for Manager " + getName() + ":");
		for (Employee employee : managedEmployees) {
			System.out.println("Employee ID: " + employee.getId() + ", Name: " + employee.getName() + ", Schedule: " + employee.getSchedule());
		}
	}

	// Getters
	public Store getManagedStore() {
		return managedStore;
	}

	public List<Employee> getManagedEmployees() {
		return managedEmployees;
	}
}
