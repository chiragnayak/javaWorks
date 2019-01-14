package General.courseEra.AlgorithmsPrinston.week3.mergeSort;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * 
 * Pass thru array, merging sub-arrays of size 1, then Repeat of sub-arrays of size 2, 4 ,8 ... < N
 * 
 * NO Recursion needed !!
 * 
 * Q : When to stop ? 
 * 
 * A : outer loop (sub-array size) :1, 2, 4, ... size < N 
 * 	   inner loop : 
 * 			low : always starts with 0, 
 * 				upper limit of low (inner loop) : N - sub-array-size
 * 				steps of low = sub-array-size + sub-array-size {i.e. left side + right side of merge}
 * 				ex : for N = 7;
 * 				outer loop : 1, 2, 4
 * 				(sub array size = 1, for iner loop, low up to < 6 ) : 0, 2, 4 
 * 				(sub array size = 2) for inner loop, low up to < 4 : 0
 * 				(sub array size = 4) for inner loop, low up to < 3 : 0
 * 			mid : low + size - 1
 * 			high : Min of (low + size + size - 1, N-1 )
 * 
 * 			Instead of directly calculating mid and high , we are calculating it in terms of low + what ever times size of sub-array for that outer iteration.
 * 
 * @author cnayak
 *
 */
public class MergeSort_bottomUp {

	public static void sort(Comparable[] array, Comparable[] auxArray) {

		SortUtil.printArray(array);

		int N = array.length;

		for (int size = 1; size < N; size = size + size) {

			for (int low = 0; low < N - size; low += (size + size)) {

				int mid = low + size - 1;
				int high = Math.min(low + size + size - 1, N - 1);

				merge(array, auxArray, low, mid, high);

				SortUtil.printArray(array);
			}
		}
	}

	private static void merge(Comparable[] array, Comparable[] auxArray, int low, int mid, int high) {

		System.out.println("Merge : low : " + low + " mid : " + mid + " high : " + high);

		// copy current state of array to auxArray
		int t = 0;
		while (t < array.length) {
			auxArray[t] = array[t];
			t++;
		}

		int i = low;
		int j = mid + 1;
		for (int x = low; x <= high; x++) {

			if (i > mid) {
				array[x] = auxArray[j++];
			} else if (j > high) {
				array[x] = auxArray[i++];
			} else if (SortUtil.lessThan(auxArray[j], auxArray[i])) {
				array[x] = auxArray[j++];
			} else {
				array[x] = auxArray[i++];
			}

		}

	}

}
