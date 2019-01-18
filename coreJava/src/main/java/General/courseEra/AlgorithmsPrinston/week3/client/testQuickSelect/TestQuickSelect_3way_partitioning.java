package General.courseEra.AlgorithmsPrinston.week3.client.testQuickSelect;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week3.quickSort.QuickSort_Djisktra_3Way_partitioning;

public class TestQuickSelect_3way_partitioning {
	
	public static void main(String[] args) {
		
		Integer [] array = new Integer []{7,1,1,1,1,4,2,3,8,8,8,9,5,6};
		
		System.out.print("BEFORE [ ");
		Arrays.asList(array).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
		
		QuickSort_Djisktra_3Way_partitioning.sort(array, 0, array.length-1);
		
		System.out.print("AFTER [ ");
		Arrays.asList(array).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
	}

}
