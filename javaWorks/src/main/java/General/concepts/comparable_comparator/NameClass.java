package General.concepts.comparable_comparator;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * [ if sorting of objects needs to be based on natural order then use Comparable ] 
 * 
 * A comparable object is capable of comparing itself (this) with another object (argument). int compareTo(argument) 
 * 
 * The (comparable) class itself must implement the java.lang.Comparable interface to compare its instances.
 * 
 * 
 * @author cnayak
 *
 */
public class NameClass implements Comparable<NameClass> {

	String name;
	
	public NameClass(String name) {
		this.name=name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	
	
	public static void main(String[] args) {
		
		List<NameClass> x = new ArrayList<>();
		x.add(new NameClass("Chira"));
		x.add(new NameClass("chira"));
		x.add(new NameClass("cHiRa"));
		x.add(new NameClass("Nayak"));
		x.add(new NameClass("N"));
		x.add(new NameClass("C"));
		
		x.stream().sorted().forEach(System.out::println);
		
		System.out.println("Chira".compareTo("Nayak"));
	}

	@Override
	public int compareTo(NameClass o) {
		
		int result = o.name.compareTo(this.name);

		System.out.println(this.name +" - "+o.name+" = "+result);
		
		if ( result > 1) {
			return 1;
		} else if (result < 1) {
			return -1;
		} else {
			return 0;
		}
	}

}
