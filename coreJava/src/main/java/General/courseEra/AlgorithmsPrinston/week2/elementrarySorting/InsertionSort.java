package General.courseEra.AlgorithmsPrinston.week2.elementrarySorting;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * 
 * Stable algorithm
 * 
 * In iteration [i], swap a[i] with each larger entry to its left.
 * 
 * @author cnayak
 *
 */
public class InsertionSort {

	public static void sort(Comparable[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if(SortUtil.lessThan(array[j], array[j-1])){
					SortUtil.swap(array, j-1, j);
				}else{
					break;
				}
				
				SortUtil.printArray(array);
			}
		}

	}

}
