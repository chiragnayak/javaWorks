package General.Employee;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	
	public String name = "NO_NAME";
	
	private double salary = -1;

	private long employeeId = -999;
	
	private String department = "NA";
	
	public Employee() {
		
	}

	public Employee(String name, long salary, long employeeId, String designation) {
		this.name = name;
		this.salary = salary;
		this.employeeId = employeeId;
		this.department = designation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public void increment(double percentage) {
		this.salary = this.salary + this.salary*(percentage/100);
	}
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return this.name+" "+this.employeeId+" - "+this.department+" - "+this.salary+" ";
	}

	@Override
	public int compareTo(Employee o) {
		long result = (this.getEmployeeId()-o.getEmployeeId());
		
		if(result > 1) {
			return 1;
		}else if(result < 1) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public class EmployeeSalaryComparator implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			
			double result = (o1.getSalary()-o2.getSalary());
			
			if(result > 1) {
				return 1;
			}else if(result < 1) {
				return -1;
			}else {
				return 0;
			}
		}
		
	}
}
