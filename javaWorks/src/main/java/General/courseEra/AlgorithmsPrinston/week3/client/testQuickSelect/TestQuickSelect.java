package General.courseEra.AlgorithmsPrinston.week3.client.testQuickSelect;

import java.util.Arrays;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;
import General.courseEra.AlgorithmsPrinston.week3.QuickSelect.QuickSelect;
import General.courseEra.AlgorithmsPrinston.week3.quickSort.QuickSort;

public class TestQuickSelect {
	
	public static void main(String[] args) {
		
		Integer [] array = new Integer []{7,1,4,2,3,8,9,5,6};
		
		System.out.println("====> "+QuickSelect.select(array, 10));
		System.out.println("====> "+QuickSelect.select(array, 9));
		System.out.println("====> "+QuickSelect.select(array, 5));
		
		SortUtil.printArray(array);
		
		QuickSort.sort(array, 0, array.length-1);
		
		System.out.print("[ ");
		Arrays.asList(array).stream().forEach(x -> System.out.print(x+" "));
		System.out.println(" ]");
	}

}
