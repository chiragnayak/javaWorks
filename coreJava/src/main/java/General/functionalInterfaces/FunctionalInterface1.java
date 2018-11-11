package General.functionalInterfaces;


/*
 * Observe this annotation : @FunctionalInterface
 * 
 * Java Docs :
 * 
 *  Conceptually, a functional interface has exactly one abstract method. 
 *  
 *  Since default methods have an implementation, they are not abstract. 
 *  
 *  If an interface declares an abstract method overriding one of the public methods of java.lang.Object, 
 *  that also does not count toward the interface's abstract method count since any implementation of the 
 *  interface will have an implementation from java.lang.Object or elsewhere. 
 * 
 * */
@FunctionalInterface
public interface FunctionalInterface1 {
	
	String thisIsOnlyAbstractMethod(); //only one abstract method is allowed in functional interface
	
	//as many default implementations are possible
	default String thisIsDefaultMethod1() {
		return "First of many defaut methods";
	}
	
	//this abstract method is possible without breaking the defination of functional interface
	/*reason :
		For a functional interface, declaring methods from Object class in an interface does
		not count as an abstract method.
	*/
	 boolean equals(Object obj);

}
