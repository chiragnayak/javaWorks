package General.streams.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

class ConsumerUse {
	public static void main(String[] args) {
		Stream<String> strings = Stream.of("hello", "world");//create Stream of type string
		Consumer<String> printString = System.out::println; 
		/*
		 * Explaination :
		 * 
		 * println Signature :  println(String x) { ...}
		 * 
		 * Consumer Interface accept Signature :  void accept(T t);
		 * 
		 * This method reference (printString) matches the signature of the abstract method in
			the Consumer interface, i.e., void accept(T). Hence, the method reference System.out::println serves to
			implement the functional interface Consumer
		 * 
		 * */
		
		
		
		strings.forEach(printString);
		
		//--> Can also be written in one line as
		Stream.of("hello", "world").forEach(System.out::println);
		
		
		
		/*
		 * Printing square of the number passed
		 * 
		 * */
		Consumer<Integer> printSquare = i -> {
								
							System.out.println(i*i);
		};
		
		printSquare.accept(1);
		printSquare.accept(2);
		printSquare.accept(3);
		

		/*
		 * Manipulate state of the object.
		 * 
		 * */
		ArrayList<person> someList = new ArrayList<>();
		someList.add(new person("Chirag","Nayak"));
		someList.add(new person("Shivam",""));
		someList.add(new person("Shivank",""));
		
		System.out.println(someList.toString());
		
		Consumer<ArrayList<person>> manipulateObj = i -> {
			
			i.stream().forEach(p -> {
				if(p.getSirName().trim().length()==0) {
					p.setSirName("Nayak");	
				}
			});
			
		};
		
		manipulateObj.accept(someList);
		
		System.out.println(someList.toString());
		
		
		
	}
	
	public static class person {
		String name;
		String sirName;
		
		person(String name, String sirname){
			this.name=name;
			this.sirName=sirname;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSirName() {
			return sirName;
		}
		public void setSirName(String sirName) {
			this.sirName = sirName;
		}
		
		@Override
		public String toString() {
		
			return name+" "+sirName;
		}
		
	}
}