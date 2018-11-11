package General.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import General.PrintUtility;
import General.Employee.Employee;

public class Concepts {
	
	static List<Employee> employees = new ArrayList<>();
	
	public static void main(String[] args) {
		
		employees.add(new Employee("Chirag", 175000, 12345, "FINANCE"));
		employees.add(new Employee("Kautilya", 175000, 13345, "FINANCE"));
		employees.add(new Employee("Ram", 200000, 23456, "KING"));
		employees.add(new Employee("Laxman", 150000, 65432, "DEFENCE"));
		employees.add(new Employee("Hanuman", 150000, 65456, "DEFENCE"));
		employees.add(new Employee("Vanar Sena", 123456, 65456, "DEFENCE"));
		employees.add(new Employee("Bharat", 110000, 32415, "HOME MINISTRY"));
		employees.add(new Employee("Chanakya", 110000, 32465, "HOME MINISTRY"));
		employees.add(new Employee("Shatrughn", 120000, 43441, "FOREIGN MINISTRY"));
		employees.add(new Employee("Vibhishan", 120000, 43442, "FOREIGN MINISTRY"));
		
		reduce();
		
		sorted();
		
		collectors();
		
		flatMap();
		
		String xx = "1234567679qw4q";
		xx.chars(); // returns IntStream !!
		
		PrintUtility.printInfo("Interesting question --> "
				+ "new Integer(123456).toString().chars().forEach(System.out::print)");
		new Integer(123456).toString().chars().forEach(x -> System.out.print(x+","));
		
		
		int [] a = {1,2,3,5,4};
		
		Arrays.sort(a);
		System.out.println(a[a.length-1]+1);
	}

	private static void flatMap() {
		
		PrintUtility.printBanner("without flatMap()");		
		String [] strings = "jhony jhony yes papa eating sugar no papa telling lies no papa open your mouth ha ha ha".split("\\s");
		Arrays.asList(strings).stream().map(x -> x.split("")).distinct().forEach(System.out::println);
		
		PrintUtility.printBanner("with flatMap() - 1 - for array input with map()");		
		Arrays.asList(strings).stream().map(x -> x.split("")).flatMap(x -> Arrays.asList(x).stream()).distinct().forEach(System.out::println);
		PrintUtility.printBanner("with flatMap() - 2 - for array without map()");
		Arrays.asList(strings).stream().flatMap(x -> Arrays.stream(x.split(""))).distinct().forEach(System.out::println);
		
		PrintUtility.printBanner("with flatMap() for List input");
		List<List<Integer>> squares = new ArrayList<>();
		
		squares.add(Arrays.asList(new Integer[] {1,2,3}));
		squares.add(Arrays.asList(new Integer[] {4,5}));
		
		squares.stream().flatMap(x -> x.stream()).map(x -> x*x).forEach(System.out::println);
	}

	private static void collectors() {
		
		PrintUtility.printBanner("Collectors");

		String someString = "row row row your boat gently down the stream";
		
		PrintUtility.printBanner("toList() - 1");
		Arrays.asList(Pattern.compile("\\s").split(someString)).stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		PrintUtility.printBanner("toMap() - 1");
		Pattern.compile("\\s").splitAsStream(someString).distinct().collect(Collectors.toMap(word -> word, word -> ((String)word).length())).forEach((x,y) -> System.out.println(x+" "+y));
		
		PrintUtility.printBanner("toSet() - 1");
		Pattern.compile("\\s").splitAsStream(someString).collect(Collectors.toSet()).forEach(System.out::println);
		
		PrintUtility.printBanner("toCollection() - TreeSet");
		Pattern.compile("\\s").splitAsStream(someString).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
		
		PrintUtility.printBanner("Grouping by -> like -> for this department has this much employees"); 
		/*
		Returns a Collector implementing a "group by" operation on input elements of type T, grouping elements according to a classification function, 
		and returning the results in a Map.
		
		unique output of classification function becomes the key 
		elements that are grouped becomes the value
		
		*/
		Map<String, List<Employee>> grpMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		grpMap.forEach((department, listOfemployee) -> System.out.println(department+" has "+listOfemployee.size()+" employees"));
		
		PrintUtility.printBanner("Grouping by -> like -> for this department Total Salary is");
		/*
		 Returns a Collector implementing a cascaded "group by" operation on input elements of type T, grouping elements according to a classification function, 
		 and then performing a reduction operation on the values associated with a given key using the specified downstream Collector
		 * */
		Map<String, Double> grpMap2 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
		grpMap2.forEach((department, totSal) -> System.out.println(department+" has total Salary as :  "+totSal));
		
		PrintUtility.printBanner("Partitioning by");
		Map<Boolean, List<Employee>> grpBoolMap = employees.stream().collect(Collectors.partitioningBy(x -> ((Employee)x).getSalary()>150000));
		
		grpBoolMap.forEach((bool, list) -> {
			System.out.println("================================= HIGHER IS "+bool+" =============================================");
			list.stream().forEach(employee -> System.out.println(employee.getName()+" "+employee.getDepartment()));
		});
	}

	private static void sorted() {
		
		//natural ordering as defined by comparable (mandatory for a stream object to implement)
		employees.stream().sorted().forEach(System.out::println);
		
		System.out.println("========================================================");
		
		//using custom comparator
		employees.stream().sorted(new Employee().new EmployeeSalaryComparator()).forEach(System.out::println);
		
		System.out.println("========================================================");
		
		//using custom comparator
		employees.stream().sorted(new Employee().new EmployeeSalaryComparator().reversed()).forEach(System.out::println);
	}

	/**
	 * 
	 * returns an optional
	 * 
	 * reduce operation applies a binary operator to each element in the stream where the first argument to the operator 
	 * is the return value of the previous application and second argument is the current stream element.

<br><br>
		Syntax :
		
		T reduce(T identity, BinaryOperator<T> accumulator);
<br><br>		
		Where, identity is initial value 
		of type T and accumulator is a 
		function for combining two values.
		
		<br><br><br>
		Binary operator : Represents an operation upon two operands of the same type, producing a result of the same type as the operands
		
		https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
	 * 
	 */
	private static void reduce() {
		
		//to find highest salary
		System.out.println(employees.stream().reduce((e1,e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2).get().getSalary());
		
		
		//to find lowest emp id
		System.out.println(employees.stream().reduce((e1,e2) -> e1.getEmployeeId() < e2.getEmployeeId() ? e1 : e2).get().getEmployeeId());
		
		//factorial of 5
		System.out.println(IntStream.rangeClosed(1, 5).reduce((x,y)-> x*y).getAsInt());
		
		//square and sum
		System.out.println(IntStream.rangeClosed(1, 5).reduce(1, (x,y)-> x*x));
	}

}
