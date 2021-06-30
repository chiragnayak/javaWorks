package General.courseEra.AlgorithmsPrinston.week3.client.testMergeSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week3.mergeSort.MergeSort;

public class TestMergeSort {
	
	public static void main(String[] args) {
		
		Integer [] data = new Integer []{7,1,4,2,3,8};
		Integer [] auxdata = new Integer [data.length];
		
		MergeSort.sort(data, auxdata, 0, data.length-1);
		
		System.out.print("[ ");
		Arrays.asList(data).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
		
	}
	
}
