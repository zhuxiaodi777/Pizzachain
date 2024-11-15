import java.util.ArrayList;
import java.util.List;

/**
 * Represents an employee in the system.
 */
public class Employee {
	private int id;
	private String name;
	private double salary;
	private String schedule;
	private List<String> leaveRecord;

	// Constructor
	public Employee(int id, String name, double salary, String schedule) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.schedule = schedule;
		this.leaveRecord = new ArrayList<>();
	}

	// Calculate the annual salary of the employee
	public double calculateAnnualSalary() {
		return salary * 12;
	}

	// Set a new schedule
	public void setSchedule(String newSchedule) {
		this.schedule = newSchedule;
		System.out.println("Schedule updated for employee " + name);
	}

	// Record leave for the employee
	public void recordLeave(String date) {
		leaveRecord.add(date);
		System.out.println("Leave recorded for employee " + name + " on " + date);
	}

	// View leave history
	public void viewLeaveHistory() {
		System.out.println("Leave History for " + name + ":");
		for (String date : leaveRecord) {
			System.out.println("Date: " + date);
		}
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getSchedule() {
		return schedule;
	}

	public List<String> getLeaveRecord() {
		return leaveRecord;
	}
}
