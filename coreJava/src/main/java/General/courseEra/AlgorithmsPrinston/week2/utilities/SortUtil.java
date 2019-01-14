package General.courseEra.AlgorithmsPrinston.week2.utilities;

import java.util.Comparator;

public class SortUtil {
	
	/**
	 * Swap item in array [] at index i and j
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void swap(Comparable [] array, int i, int j){
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean lessThan(Comparable x, Comparable y){
		return x.compareTo(y)<0;
	}
	
	public static boolean lessThan(Comparator c, Comparable x, Comparable y){
		return c.compare(x, y) < 0;
	}
	
	public static <T> void printArray(T[] array) {
		
		StringBuilder sb = new StringBuilder("[ ");

		for (int i = 0; i < array.length; i++) {
			sb.append(array[i] + " ");
		}

		sb.append("]");

		System.out.println(sb.toString());
	}

}
