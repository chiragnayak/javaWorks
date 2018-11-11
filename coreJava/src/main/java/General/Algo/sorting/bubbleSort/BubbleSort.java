package General.Algo.sorting.bubbleSort;

import java.util.Arrays;

/**
 * 
 * Scan through the array, searching pairs of consecutive elements that are ordered wrongly. 
 * 
 * Then find a j, such that array[j+1] < array[j]. 
 * 
 * • Whenever such a pair is found, swap them and continue searching until the end of the
 * array and then back from the beginning again. 
 * 
 * • (this is to optimize) Stop when a scan through the entire array does not even find a single pair.
 * 
 * Worst-case space complexity: auxiliary
	Best-case performance: О(n) comparisons, О(1) swaps
	Worst-case performance: О(n2) comparisons, О(n2) swaps
	Average performance: О(n2) comparisons, О(n2) swaps
 * 
 * @author cnayak
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		Arrays.stream(bubbleSort(new int[] { 2, 5, 1, 7, 9, 1, 0, 4 })).forEach(System.out::print);

	}

	public static int[] bubbleSort(int[] array) {
		
		boolean swapDone;

		for (int passCount = 0; passCount < array.length; passCount++) {
			
			swapDone = false;

			int i = 0;
			int j = 1;

			while (i < array.length && j < array.length) {

				if (array[j] < array[i]) {

					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					
					swapDone = true;
				}

				i++;
				j++;
				
			}
			
			
			if(!swapDone) {
				break;
			}

			System.out.print("pass :  " + passCount + " -> ");
			Arrays.stream(array).forEach(System.out::print);
			System.out.println("");

		}

		return array;
	}

}
