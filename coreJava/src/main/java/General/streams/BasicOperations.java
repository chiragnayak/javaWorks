package General.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BasicOperations {
	
	public static void main(String[] args) {
		
		//convert int [] to stream
		System.out.println("====== int [] to stream using Arrays.stream(Array of double/int/long/T) ======== ");
		//Arrays.stream does notsork for char []
		
		//way : 1 -> Arrays.stream()
		int [] x = new int [] {1,2,3,4};
		Arrays.stream(x).forEach(System.out::print);
		
		System.out.println("");
		
		//way : 2 -> IntStrean.of()
		IntStream.of(x).map(o -> o*o*o).forEach(System.out::print);
		
		System.out.println("");
		
		Arrays.stream(x).map(m -> m*m).forEach(System.out::print);
		
		System.out.println("");
		
		//convert String to char [] then to stream
		// -->> Arrays.stream("chirag nayak".toCharArray()); // Arrays.stream() does not work for char []
		
		System.out.println("");
		
		System.out.println("way 1: string to split for each character then to stream  then map to upper case to print");
		Arrays.asList("chirag nayak".split(""))
			.stream()
			.map(m -> m.toUpperCase())
			.forEach(System.out::print);
		
		System.out.println("");
		
		System.out.println("way 2: string to chars() to mapToObj() to print");
		"chirag nayak dum dum dum".chars() //-> this returns IntStream
			.mapToObj(c -> (char)c) //maps to charcter stream
			.map(ch -> ch.toUpperCase(ch)) //makes it all CAPS
			.forEach(System.out::print); //prints each character
		
		System.out.println("");
		
		System.out.println("==== String[] to stream ========");
		
		String strArr [] = {"chirag", "nayak", "muchalla", "college"};
		
		System.out.println("way 1 : Arrays.asList()");
		Arrays.asList(strArr).stream().forEach(System.out::print);
		
		System.out.println("");
		
		System.out.println("way 2 : Arrays.stream()");
		Arrays.stream(strArr).sorted().map(mm -> mm.toUpperCase()).forEach(System.out::print);
		
		System.out.println("");
		
		"someString.chars() i.e. IntStream to Strean <String>".chars()
			.mapToObj(chToStr -> new String(((char)chToStr)+""))
			.forEach(System.out::print);
		
	}

}
