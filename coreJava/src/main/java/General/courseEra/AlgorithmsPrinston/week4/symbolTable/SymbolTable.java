package General.courseEra.AlgorithmsPrinston.week4.symbolTable;

/**
 * Conventions : 
 * 	Vaues are not null
 * 	Method get() returns null if key is not present
 * 	Method put() overrites the old value with the new value.
 * 
 * Assumptions :
 * 
 * 	Assume that Keys are "Comparable" ( use compareTo())
 * 	Assume Keys are any generic type, use equals(), to test equality (use hashCode() to scramble key)
 * 
 * Best Practices : 
 * Use immutable types for the table keys.
 * 		Immutables : 
 * 			String, Integer, Double, java.io.File ....
 * 		Mutables : 
 * 			StringBuilder, arrays ... 
 *  
 * equals() -> java requirements
 * 	(1) Reflexive :  x.equals(x) -> true
 * 	(2) Symettric : x.equals(y) -> true, then y.equals(x) -> true
 * 	(3) Transitive : x.equals(y) -> true, then y.equals(z) -> true , then x.equals(z) -> true
 * 	non-null : x.equals(null) -> false
 * 
 *  (1) (2) (3) makes equivalence relationship
 * 
 * Default Implementations : to test whether the references are equal.
 * 
 * 	x == y : compare references
 * 
 * 	Customized implementations in : Integer, double, String, File, URL ...
 * 
 * Standard Recipe for user defined types (overriding equals())
 * =============================================================
 * 
 * 	Optimization for reference equality (check if refrenences are equal return true)
 * 	Check against null
 * 	Check that two objects are of the same type and class
 * 	Compare each significant field : 
 * 		if field is a primitive, use ====
 * 		if field is a object , use equals()
 * 		if field is an array, apply above two to each entry. (alternatively use Arrays.equals(a, b) or Arrays.deepEquals(a, b), but not a.equals(b))
 * 
 *  Make compareTo() consistant with equals()
 *  	i.e. if x.equals(y) is true if and only if x.compareTo(y) == 0 
 * 
 * @author cnayak
 *
 * @param <Key>
 * @param <Value>
 */
public class SymbolTable <Key, Value> {
	
	
	public void put (Key key, Value value) {
		
	}
	
	public Value get(Key key){
		
		return null;
	}
	
	public void delete (Key key) {
		put(key, null);//lazy version of delete
	}
	
	public boolean contains (Key key){
		
		return get(key) !=null;
	}

	public boolean isEmpty(){
		
		return true;
	}
	
	public int size() {
		
		return 0;
	}
	
	public Iterable <Key> keys() {
		
		return null;
		
	}
}
