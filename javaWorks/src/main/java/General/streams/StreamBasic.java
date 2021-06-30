package General.streams;

import java.util.TreeMap;
import java.util.stream.Stream;

import General.Employee.Employee;

public class StreamBasic {

	public static void main(String[] args) {
		
		Stream.of(1, 2, 3, 4, 5)
		.peek(i -> System.out.printf("+%d+", i))
		.map(i -> i * i)
		.peek(i -> System.out.printf("-%d-", i))
		.count();
		
		/*		OUTPUT  
		 * 
		 * +1+-1-+2+-4-+3+-9-+4+-16-+5+-25-
		 * 
		 * */
		
		int [] x = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(Stream.of(1,2,3,4,5,6,7,8,9).anyMatch(y -> {
			if(y%2==0) {
				System.out.println(y);
				return true;
			}else { 
				return false;
			}
		}));
		
		yyy.put(new chirag(1), "Chirag");/*//--> Exception in thread "main" java.lang.ClassCastException: General.streams.chirag cannot be cast to java.lang.Comparable
		at java.util.TreeMap.compare(TreeMap.java:1294)
		at java.util.TreeMap.put(TreeMap.java:538)
		at General.streams.StreamBasic.main(StreamBasic.java:35)*/
		yyy.put(new chirag(2), "Chirag");
		Stream.of(yyy).forEach(System.out::println);
		
	}
	
	static TreeMap<Employee, String> xxx =new TreeMap<>();
	static TreeMap<chirag, String> yyy = new TreeMap<>();
	

}

class chirag {
	
	int id;
	
	public chirag(int id){
		
	}
	
}
