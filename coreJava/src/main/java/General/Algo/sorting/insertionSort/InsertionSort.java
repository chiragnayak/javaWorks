package General.Algo.sorting.insertionSort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * In the insertion sort, we first select an element and then insert the element into position where it should sit
 * 
 * Time Complexity: O(n^2)
 * 
 *  Worst-case space complexity: О(n) total, O(1) auxiliary
	Best-case performance: O(n) comparisons, O(1) swaps
	Worst-case performance: О(n2) comparisons, swaps
	Average performance: О(n2) comparisons, swaps
 * 
 * 
 * 
 * @author cnayak
 *
 */
public class InsertionSort {

	public static void main(String[] args) {

		IntStream.of(insertionSort(new int[] { 3, 6, 1, 7, 9, 8, 4, 2, 5, 0, 1, 3 })).forEach(System.out::print);
		
		System.out.println("");
		
		Arrays.stream(insertionSort(new int[] { 2, 5, 3, 4, 6, 8, 9, 1, 0 })).forEach(System.out::print);
	}

	public static int[] insertionSort(int[] array) {
		
		int xx = 1;
		int yy = 0;
		
		int xxx = xx/yy;
		
		float fff = Float.NaN;

		// position by position : 0th to length
		for (int outerPointer = 1; outerPointer < array.length; outerPointer++) {

			// from 0th index to the outer-pointer (position)
			for (int innerPointer = 0; innerPointer < outerPointer; innerPointer++) {

				// keep swapping if outer-pointer element is smaller that inner pointer element 
				if (array[outerPointer] < array[innerPointer]) { // increasing order

					int temp = array[outerPointer];
					array[outerPointer] = array[innerPointer];
					array[innerPointer] = temp;
					
					//do not add break statement here. no need to add break anywhere.
				}
			}

		}

		return array;

	}

}
