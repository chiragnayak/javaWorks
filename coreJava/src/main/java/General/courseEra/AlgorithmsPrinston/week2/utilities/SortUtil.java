package General.courseEra.AlgorithmsPrinston.week2.utilities;

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

}
