package General.courseEra.AlgorithmsPrinston.week2.elementrarySorting;

import java.util.Comparator;

import General.courseEra.AlgorithmsPrinston.week2.utilities.SortUtil;

/**
 * In iteration [i], swap a[i] with each larger entry to its left.
 * 
 * @author cnayak
 *
 */
public class InsertionSort_withComparator {

	public static void sort(Comparator c, Comparable[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if(SortUtil.lessThan(c, array[j], array[j-1])){
					SortUtil.swap(array, j-1, j);
				}else{
					break;
				}
				
				SortUtil.printArray(array);
			}
		}

	}

}
