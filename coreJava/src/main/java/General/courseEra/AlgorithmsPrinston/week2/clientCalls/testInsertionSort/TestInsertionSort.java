package General.courseEra.AlgorithmsPrinston.week2.clientCalls.testInsertionSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week2.elementrarySorting.InsertionSort;

public class TestInsertionSort {
	
	public static void main(String[] args) {
		
		Integer [] data = new Integer []{7,1,4,2,3,8,9,5,6,11,33,99,44,77,55,66,12,323,456,43,236,6456,234,23432,700,11};
		
		InsertionSort.sort(data);
		
		Arrays.asList(data).stream().forEach(System.out::println);
	}

}
