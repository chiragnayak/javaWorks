package General.courseEra.AlgorithmsPrinston.week2.elementrarySorting;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * In iteration i, find index min of smallest remaining entry Swap a[i] with
 * a[min]
 * 
 * 
 * Algorithm : we move from index 0 to N index of the array (i.e) from left to
 * right
 * 
 * at any index [i] ...
 * 
 * Invariants :
 * 
 * - Entries at the left of [i] including at [i] are fixed and in ascending order. 
 * - no entry to right of [i] is smaller than any entry to left of [i]
 * 
 * Selection sort uses (N-1) + (N-2) + .... + 1 + 0 ~ N^2/2 copares and N
 * exchanges.
 * 
 * - Running time is insensitive to input. Quadratic time even if the input is sorted. 
 * - Data movement is minimal. Linear number of exchanges.
 * 
 * @author cnayak
 *
 */
public class SelectionSort {

	public static void sort(Comparable[] array) {

		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			for (int j = i; j < array.length; j++) {
				if (SortUtil.lessThan(array[j], array[minIndex])) {
					minIndex = j;
				}
			}
			SortUtil.swap(array, i, minIndex);
		}
	}

}
