package General.courseEra.AlgorithmsPrinston.week3.client.testQuickSort;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;
import General.courseEra.AlgorithmsPrinston.week3.quickSort.QuickSort;

public class TestQuickSort {
	
	public static void main(String[] args) {
		
		Integer [] data = new Integer []{7,1,4,2,3,8,9,5,6};
		
		SortUtil.printArray(data);
		
		QuickSort.sort(data, 0, data.length-1);
		
		System.out.print("[ ");
		Arrays.asList(data).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
		
	}
	
}
