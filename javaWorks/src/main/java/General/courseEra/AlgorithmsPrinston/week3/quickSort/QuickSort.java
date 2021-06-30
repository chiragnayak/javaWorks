package General.courseEra.AlgorithmsPrinston.week3.quickSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * 
 * recursive method
 * in-place sorting algorithm
 * Partitioning > needs constant extra space
 * depth of recursion > logrithmic extra space
 * 
 * best case : number of compares, devides exactly in half always, N log N
 * worst case (array already sorted) : number of compares ~ 1/2 N^2 (hence, it is important to shuffle the array in the beginning)
 * Average case : 
 * 		propostion : the average number of compares Cn to wuikc sort an array of "n" disctinct keys is ~ 2n ln n
 * 					 the number of exchanges is ~ i/2 n ln n
 * 
 * First partition, so that, for some j
 * 
 *  - entry a[j] is in place
 *  - no larger entry on left of array (all smaller entries in left of a[j])
 *  - no smaller entry in right of array (all larger entries in right of a[j])
 * 
 * Second, sort each side recursively. 
 * 
 * 
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
	 * 		Scan i from left to right, so long as array[i] < array [partition] [therefore -> everything at the left of i is less than partition element]
	 * 		Scan j from right to left so long as array[j] > array[partition] [ therefore -> everything at the right of j is higher than partition element]
	 * 
	 * 		exchange array[i] and array[j];
	 * 
	 * 		keep doing Phase-1 till pointer's cross. i.e. i>=j. then go to Phase 2
	 * 
	 *  Phase -2 
	 *  
	 *  	exchange array[partition] with array [j]
	 *  
	 *  Post this elements at right of partition will be greater that array[partition] and left will be lesser than array[partition]. 
	 *  
	 *  i.e. array[partition] element is in correct position.
	 *  
	 *   return partition position. 
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
		
		int partition = low;
		
		while(true){
			
			//Rule : everything at the left of i is less than partition element
			//find item on left to swap (basically higher that partition element)
			while(SortUtil.lessThan(array[i], array[partition])){
				i++;
				if(i>=high) break;
			}
			
			//Rule : everything at the right of j is higher than partition element
			//find item on the right to swap (basically smaller than partition element)
			while(SortUtil.lessThan(array[partition], array[j])) {
				j--;
				if(j<=low) break;
			}
			
			//check if pointers cross
			if(i>=j){
				break;
			}
			
			//swap higher element with smaller element
			//at j (on the right side) we found element which is smaller than partition element
			//ar i (on the left side) we found element which is higher than partition element
			SortUtil.swap(array, i, j);
			
			System.out.print("<>");
			SortUtil.printArray(array);
			
		}
		
		//once the pointers cross, all the elements to right of jth is higher than partition element
		//and all the elements at left of jth are smaller than partition element.
		SortUtil.swap(array, partition, j);
		//question : why it is exchange with jth ?
		
		System.out.print("==");
		SortUtil.printArray(array);
		
		//after swap, now partition (which started from low) is jth element
		//return j
		
		return j;
		
	}
	

}
