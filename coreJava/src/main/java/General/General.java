package General;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;

import General.Employee.Employee;

public class General {
	
	public String xx() {
		return ("1");
	}
	
	public final static String xx(int data) {
		return "2";
	}
	
	public static void main(String[] args) throws Exception {
		General xx = new General();
		System.out.println(xx.xx());
		
		short x  = 9;
		System.out.println(xxx(x,6));
		
		if(x==1 && x/0==10) {
			
		}else {
			System.out.println(false);
		}
		
		/*Object o = new Object();
		synchronized (Thread.currentThread()) {
			o.wait();
			o.notify();
		}*/
		
		BigDecimal d1 = new BigDecimal(2.0);
		BigDecimal d2 = new BigDecimal(2.00);
		
		String a = "java";
		String b = "java";
		String c = new String("java");
		System.out.println(a.equals(c));
		System.out.println(b==c.intern());
		
		System.out.println(d1.equals(d2));
		
//		List<String> str = new ArrayList<>();
//		
//		str = Arrays.asList(new String [] {"A","B","C","D"});
//		
//		Iterator<String> xxxu = str.iterator();
//		while(xxxu.hasNext()) {
//			String temp = xxxu.next();
//			if(temp.equals("B")) {
//				str.remove(temp);
//			}
//		}
//		
		
		Arrays.stream(new int [] {1,2,3,4}).map(n -> 3 * n + 1).filter(i -> i > 10).average().ifPresent(System.out::println);
		
		Employee e1 = new Employee("Chirag", 1000, 1000, "President");
		Employee e2 = new Employee("Rama", 1000, 1000, "NextToPresident");
		Employee e3 = new Employee("LaxMan", 1000, 1000, "PrimeMinister");
		Employee e4 = new Employee("BhaRat", 1000, 1000, "FinanceMinister");
		
		LinkedHashMap<String,Employee> netElementList = new LinkedHashMap<>();
		netElementList.put("e1", e1);
		netElementList.put("e2", e2);
		netElementList.put("e3", e3);
		netElementList.put("e4", e4);
		
		checkIfPresent<String, Employee, LinkedHashMap<String,Employee>> mapChecker = (str, list) -> {
			
			if(list.containsKey(str)) {
				return list.get(str);
			}else {
				return new Employee();				
			}
		};
		
		System.out.println(mapChecker.checkKey("e3", netElementList).getName());
		System.out.println(mapChecker.checkKey("e6", netElementList).getName());
		
	}
	
	public static int xxx(int x, int y) {
		return x+y;
	}
	
	@FunctionalInterface
	interface checkIfPresent <T1 extends String, T2 extends Employee, T3 extends LinkedHashMap<String, T2>> {
		
		T2 checkKey(T1 elementName, T3 listToSearch);
	}

}

