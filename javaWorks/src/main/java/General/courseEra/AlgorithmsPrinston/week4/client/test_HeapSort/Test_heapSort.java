package General.courseEra.AlgorithmsPrinston.week4.client.test_HeapSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week4.HeapSort.HeapSort;
import General.courseEra.AlgorithmsPrinston.week4.HeapSort.HeapSort_InPlace;

public class Test_heapSort {
	
	public static void main(String[] args) {
		
		Integer [] data = {4,1,3,2,6,8,9,3,2,0,11,2,33,44,565,789,23,123,0,12};
		
		HeapSort.sort_usingExtraMemory(data);
		
		System.out.print(" SORTED [ ");
		Arrays.asList(data).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
		
		data = new Integer[] {4,1,3,2,6,8,9,3,2,0,11,2,33,44,565,789,23,123,0,12,1,1,1,1};
		
		HeapSort_InPlace.sort(data);
		
		System.out.print(" SORTED [ ");
		Arrays.asList(data).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
	}

}
