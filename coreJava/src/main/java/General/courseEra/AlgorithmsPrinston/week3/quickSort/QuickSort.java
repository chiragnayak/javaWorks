package General.courseEra.AlgorithmsPrinston.week3.quickSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * @author cnayak
 *
 */
public class QuickSort {
	
	public static void sort(Comparable [] array, int low, int high){
		
		System.out.println("Sort : low "+low+"th high : "+high+"th");
		
		if(high <= low){
			return;
		}
		
		//find partitioning point
		int partition = partitioning(array, low, high);
		
		System.out.println("partition as : "+partition+"th position as "+array[partition]);
		
		sort(array,low, partition-1);
		sort(array, partition+1, high);
		
	}
	
	/**
	 * Repeat until i and j pointers cross.
	 * 
	 * 	Phase - 1
	 * 		Scan i from left to right, so long as array[i] < array [pivot] [therefore -> everything at the left of i is less than pivot element]
	 * 		Scan j from right to left so long as array[j] > array[pivot] [ therefore -> everything at the right of j is higher than pivot element]
	 * 
	 * 		exchange array[i] and array[j];
	 * 
	 * 		keep doing Phase-1 till pointer's cross. i.e. i>=j. then go to Phase 2
	 * 
	 *  Phase -2 
	 *  
	 *  	exchange array[pivot] with array [j]
	 *  
	 *  Post this elements at right of pivot will be greater that array[pivot] and left will be lesser than array[pivot]. 
	 *  
	 *  i.e. array[pivot] element is in correct position.
	 *  
	 *   return pivot position. 
	 * 
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partitioning (Comparable [] array, int low, int high){
		
		int i = low+1;
		int j = high;
		
		int pivot = low;
		
		while(true){
			
			//everything at the left of i is less than pivot element
			//find item on left to swap (basically higher that pivot element)
			while(SortUtil.lessThan(array[i], array[pivot])){
				i++;
				if(i>=high) break;
			}
			
			//everything at the right of j is higher than pivot element
			//find item on the right to swap (basically smaller than pivot element)
			while(SortUtil.lessThan(array[pivot], array[j])) {
				j--;
				if(j<=low) break;
			}
			
			//check if pointers cross
			if(i>=j){
				break;
			}
			
			//swap higher element with smaller element
			SortUtil.swap(array, i, j);
			
			System.out.print("<>");
			SortUtil.printArray(array);
			
		}
		
		//once the pointers cross, all the elements to right of jth is higher than pivot element
		//and all the elements at left of jth are smaller than pivot element.
		SortUtil.swap(array, pivot, j);
		//question : why it is exchange with jth ?
		
		System.out.print("==");
		SortUtil.printArray(array);
		
		//after swap, now pivot (which started from low) is jth element
		//return j
		
		return j;
		
	}
	

}
