package General.Algo.searching;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * Auxiliary Space: O(1) in case of iterative implementation. In case of
 * recursive implementation, O(Logn) recursion call stack space.
 * 
 * Binary Search: Search a sorted array by repeatedly dividing the search
 * interval in half.
 * 
 * Begin with an interval covering the whole array.
 * 
 * If the value of the search key is less than the item in the middle of the
 * interval, narrow the interval to the lower half. Otherwise narrow it to the
 * upper half.
 * 
 * Repeatedly check until the value is found or the interval is empty.
 * 
 * We basically ignore half of the elements just after one comparison.
 * 
 * Compare x with the middle element.
 * 
 * If x matches with middle element, we return the mid index.
 * 
 * Else If x is greater than the mid element, then x can only lie in right half
 * subarray after the mid element. So we recur for right half.
 * 
 * Else (x is smaller) recur for the left half.
 * 
 * @author cnayak
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 3, 5, 3, 65, 32, 6, 78, 3, 5, 7 };
		Arrays.sort(array);

		Arrays.binarySearch(array, 1);

		IntStream.of(array).forEach(x -> System.out.print(x + " "));
		System.out.println("\nAt position " + binarySearch(array, 32));

	}

	public static int binarySearch(int[] array, int target) {

		int low = 0;
		int high = array.length - 1;
		int mid = -1;

		while (low < high) {

			mid = (low + high) / 2; // calculate the mid

			if (array[mid] > target) { // target lies in first half, move the
										// high to 1 less than mid
				high = mid - 1;
			} else if (array[mid] < target) { // target lies in second half,
												// move the low to 1 over than
												// mid
				low = mid + 1;
			} else {
				break; // either found or not present.
			}
		}

		if (array[mid] == target) { // check if found
			return mid;
		} else {
			return -1;
		}

	}

}
