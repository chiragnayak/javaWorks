package General.concepts.generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestBounds {
	
	
	public static void main(String[] args) {
		
		
		/*
		 * Un-bounded
		 * */
		
		/*
		 * Upper bound
		 * 
		 * by "upper" the indication is X (on LHS) is the upper most class, so only a class Y which extends X can be on the RHS
		 * 
		 * 
		 * List <? extends X> obj = ArrayList <Y>();
		 * 
		 * i.e : any class Y that extends X can be on RHS
		 * 
		 * X should be Parent of Y X can be equal to X
		 * 
		 * Points to note : the list becomes virtually immutable.
		 * 
		 * You cannot add to such lists where we have extends
		 * 
		 * because java does not know what sub-type is actually being added to the list.
		 * 
		 * EX : 
		 *  public static void main(String[] args) {
		 * 
		 *  	6: List<? extends Bird> birds = new ArrayList<Bird>(); 
		 *  	7: birds.add(new Sparrow()); // DOES NOT COMPILE 
		 *  	8: birds.add(new Bird()); // DOES NOT COMPILE 
		 *  
		 *   } 
		 *  
		 *  The problem stems from the fact that Java doesn’t know what type List<? extends Bird> really is. 
		 *  It could be List<Bird> or List<Sparrow> or some other generic type that hasn’t
		 * even been written yet. Line 7 doesn’t compile because we can’t add a Sparrow
		 * to List<Bird>, and line 8 doesn’t compile because we can’t add a Bird to
		 * List<Sparrow>. From Java’s point of view, both scenarios are equally possible
		 * so neither is allowed.
		 * 
		 */
		List <? extends Exception> testObj1 = new ArrayList<RuntimeException>(); //valid
		List <? extends Exception> testObj2 = new ArrayList<Exception>(); //valid
//		List <? extends Exception> testObj3 = new ArrayList<Throwable>(); //in-valid, compilation error
		
//		testObj1.add(new RuntimeException("This is compilation error. You cannot add, but yeah you can remove."));
//		testObj1.add(new Exception("This is compilation error. You cannot add, but yeah you can remove."));
			
		/*
		 * 
		 * Lower bound
		 * 
		 * by "lower" the indication is X (on LHS) is the lower most class, so only a class Y which is super of X can be on the RHS
		 * 
		 * List <? super X> obj = ArrayList <Y>();
		 * 
		 * Y should be Parent of X Y can be equal to X
		 * 
		 * EX : List<? super String> obj)
		 * 
		 * we are telling Java that the obj will be a list of String objects or a list
		 * of some objects that are a superclass of String. Either way, it is safe to
		 * add a String to that list. or also you can add subclasses of String (if there are any)
		 * 
		 * Like in below :
		 * 
		 * List <? super Exception> list = RHS
		 * 
		 * on RHS : acceptable classes are -> new ArrayList<Throwable OR Exception OR Object> (); //which are super classes of Exception
		 * 
		 * but you can add Exception, and its subclasses to the list, like : RuntimeException, IOException etc.
		 * 
		 */
//		List <? super Exception> testObj4 = new ArrayList<RuntimeException>(); //in-valid, compilation error
		List <? super Exception> testObj5 = new ArrayList<Exception>(); //valid
		List <? super Exception> testObj6 = new ArrayList<Throwable>(); //valid
		
		testObj5.add(new Exception()); //valid
//		testObj5.add(new Throwable()); //compilation error
		testObj5.add(new RuntimeException()); //valid
		testObj5.add(new IOException()); //valid
//		testObj6.add(new Throwable()); //compilation error
		
		/*
		 * PECS
		 * 
		 * Provider Extends
		 * Consumer Super
		 * 
		 * */
		
		
	}

}
