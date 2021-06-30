package General.predicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import General.PrintUtility;

public class PredicateTest {
	public static void main(String[] args) {
		
	/*
	 *  interface Predicate<T>
	 *  
     * Evaluates this predicate on the given argument.
     *
     * 	@param t the input argument
     * 	@return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     
		boolean test(T t);
	 * 
	 * */
		
//		Predicate<String> nullCheck = arg -> arg != null;
//		Predicate<String> emptyCheck = arg -> arg.length() > 0;
//		Predicate<String> nullAndEmptyCheck = nullCheck.and(emptyCheck);
//		String helloStr = "hello";
//		System.out.println(nullAndEmptyCheck.test(helloStr));
//		String nullStr = null;
//		System.out.println(nullAndEmptyCheck.test(nullStr));
		
		int [] xx = {};
		
		PrintUtility.printInfo("case 1");
		ArrayList<String> nullList = (ArrayList<String>)null;
		System.out.println(nullAndLengthCheck(nullList, 1));
		
		PrintUtility.printInfo("case 2");
		System.out.println(nullAndLengthCheck(new ArrayList<String>(), 0));
		
		PrintUtility.printInfo("case 3");
		ArrayList<String> someAList = new ArrayList<String>();
		someAList.add("This is Me !");
		System.out.println(nullAndLengthCheck(someAList,1));
		
		PrintUtility.printInfo("case 4");
		LinkedList<String> llist = new LinkedList<>();
		System.out.println(nullAndLengthCheck(llist,0));
		
		PrintUtility.printInfo("case 5");
		String [] strArr = null;
		System.out.println(nullAndLengthCheck(strArr,0));
		strArr = new String [] {"testString"};
		System.out.println(nullAndLengthCheck(strArr,1));
		
		PrintUtility.printInfo("case 6");
		int [] intArr = null;
		System.out.println(nullAndLengthCheck(intArr,0));
		intArr = new int [] {1};
		System.out.println(nullAndLengthCheck(intArr,1));
		
		PrintUtility.printInfo("case 7");
		HashMap<String, String> map = new HashMap<>();
		System.out.println(nullAndLengthCheck(map,0));
		
		//Test side usage
		if(nullAndLengthCheck(someAList,1)) {
			System.out.println(someAList.get(0));
		}
		 
	}
	
//	public static boolean nullAndLengthCheck(ArrayList<String> someObject, int leasthExpectedLength) {
//		
//		Predicate<ArrayList<String>> AryListNullAndEmptyCheck = (arg) -> {
//			if(arg!=null && arg.size()>=leasthExpectedLength) {
//				return true;
//			}else {
//				return false;
//			}
//		};
//		
//		return AryListNullAndEmptyCheck.test(someObject);
//		
//	}
	
	public static boolean nullAndLengthCheck(Map<?, ?> somemap, int leasthExpectedLength) {
		return nullAndLengthCheckGeneric(somemap, leasthExpectedLength);
	}
	
	public static boolean nullAndLengthCheck(List <?> someList, int leasthExpectedLength) {
		return nullAndLengthCheckGeneric(someList, leasthExpectedLength);
	}
	
	public static boolean nullAndLengthCheck(int [] someintArray, int leasthExpectedLength) {
		return nullAndLengthCheckGeneric(someintArray, leasthExpectedLength);
	}
	
	public static boolean nullAndLengthCheck(String [] someStringArray, int leasthExpectedLength) {
		return nullAndLengthCheckGeneric(someStringArray, leasthExpectedLength);
	}
	
	public static <T> boolean nullAndLengthCheckGeneric(T someObject, int leastExpectedLength) {
		
		Predicate<T> nullAndLengthCheckPredicate = (arg) -> {
			if(arg!=null) {
				
				if(someObject instanceof String []) {
					return ((String [])someObject).length>=leastExpectedLength ? true : false;
				}else if(someObject instanceof int []) {
					return ((int [])someObject).length>=leastExpectedLength ? true : false;
				}else if(someObject instanceof List) {
					return ((List)someObject).size()>=leastExpectedLength ? true : false;
				}else if(someObject instanceof Map) {
					return ((Map)someObject).size()>=leastExpectedLength ? true : false;
				}else {
					PrintUtility.printBanner(someObject.getClass().getSimpleName()+" >> TYPE NOT SUPPORTED !!", false);
				}
					
				
				return true;
			}else {
				return false;
			}
		};
		
		return nullAndLengthCheckPredicate.test(someObject);
		
	}
}
