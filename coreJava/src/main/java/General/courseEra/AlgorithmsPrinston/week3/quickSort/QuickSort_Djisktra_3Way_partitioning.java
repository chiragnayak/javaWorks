package General.courseEra.AlgorithmsPrinston.week3.quickSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

public class QuickSort_Djisktra_3Way_partitioning {
	

	public static void sort (Comparable [] array, int low, int high) {
		
		if(high <=low){
			return;
		}
		
		Comparable v = array[low];
		
		int lt = low;
		int gt = high;
		int i = low;
		
		while(i <= gt){
			
			System.out.print("v : "+v+" lt : "+lt+" i : "+i+" gt :"+gt);
			
			int result = array[i].compareTo(v);
			
			if(result < 0){
				SortUtil.swap(array,  lt++, i++);
			}
			else if(result > 0 ){
				SortUtil.swap(array, i, gt--);
			}else{
				i++;
			}
			
			SortUtil.printArray(array);
		}
		
		sort(array, low, lt-1);
		sort(array, gt+1, high);
		
		
	}

}
