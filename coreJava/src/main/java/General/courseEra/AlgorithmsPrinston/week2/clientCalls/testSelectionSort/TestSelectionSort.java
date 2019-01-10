package General.courseEra.AlgorithmsPrinston.week2.clientCalls.testSelectionSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week2.elementrarySorting.SelectionSort;

public class TestSelectionSort {
	
	public static void main(String[] args) {
		
		Integer [] data = new Integer []{7,1,4,2,3,8,9,5,6};
		
		SelectionSort.sort(data);
		
		Arrays.asList(data).stream().forEach(System.out::println);
	}

}
