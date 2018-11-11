package General.concepts.comparable_comparator;

import java.util.Comparator;

/**
 * 
 * A class that is to be used for comparing two object of other (same) type is called comparator class and must implement 
 * comparator interface.
 * 
 * We create multiple separate classes (that implement Comparator) to compare by different members of the target class (the one 
 * which is being compared).
 * 
 * 
 * 
 * @author cnayak
 *
 */
public class MyComparator implements Comparator<NameClass>{

	@Override
	public int compare(NameClass o1, NameClass o2) {
		
		return o1.compareTo(o2);

	}
	
	public static void main(String[] args) {
		
		MyComparator xx = new MyComparator();
		NameClass o1 = new NameClass("Chirag");
		NameClass o2 = new NameClass("cHirag");
		
		System.out.println(xx.compare(o1, o2));
	}

}
