package General.Algo.sorting.selectionSort;

import java.util.Arrays;

/**
 * Notes:
 * 
 * The Selection sort algorithm is based on the idea of finding the minimum or maximum element in an unsorted array and then putting it in its correct position in a sorted array.
 * 
 * In selection sort, we first selected a position and then found the element that should sit there.
 * 
 * in-place comparison sort.
 * 
 * Time complexity : O(n^2) : O n square
 * 
 *  Worst-case space complexity: O(1) auxiliary
	Best-case performance: О(n2) comparisons, О(n) swaps
	Worst-case performance: О(n2) comparisons, О(n) swaps
	Average performance: О(n2) comparisons, О(n) swaps
	 
 * 
				// consider entity at location as the smallest, 
				// select smallest in remaining array
				// swap it with entity at currect location
				// ++ location and then repeat
			
 * 
 * @author cnayak
 *
 */
public class SelectionSort {
	
	public static void main(String[] args) {
		
		
		int [] array = new int [] {2,5,4,1,6,8,3,1,0};
		
		Arrays.stream(selectionSort(array)).forEach(System.out::print);
		
	}

	public static int [] selectionSort(int[] array) {
		
		int index = 0;
		
		int smallestNow;
		
		for(int outerPosition = 0; outerPosition < array.length; outerPosition++) {
			
			//mark or assume that the array[outerPosition] as  "smallest"
			//find the number smaller than this number, in remaining array and update "smallest" and save its index, if found any
			//swap this new smallest number with number at outerPosition position.
			//now number at outerPosition is in its correct position (smallest)
			// ++ outerPosition
			//repeat 
			smallestNow = array[outerPosition];
			
			for(int i=outerPosition+1; i< array.length; i++) {
				
				if(array[i] < smallestNow) {
					
					smallestNow = array[i];
					index = i;
				}
			}
			
			//swap the "now" smallest with the outer-index postion
			int temp = array[outerPosition];
			array[outerPosition] = smallestNow;
			array[index] = temp;
			
		}		
		return array;
		
	}
}
