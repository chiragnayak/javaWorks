package General.leetCode.easy;

import java.util.ArrayList;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] array1 = new int[] { 1, 2, 3, 0, 0, 0, 0, 0, 0 };
		int[] array2 = new int[] { 2, 5, 6 };

		optiMizedSol2(array1, 3, array2, 3);
		
		printMe(array1);
		
		array1 = new int[] { 1, 2, 3, 0, 0, 0, 0, 0, 0 };
		array2 = new int[] { };

		optiMizedSol2(array1, 3, array2, 0);
		
		printMe(array1);
		
	}
	
	/**
	 * compare and start filling from back or end of each array. This will now require swapping operation.. also no memoization is required (list solution).
	 * 
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 */
	public static void optiMizedSol2(int[] array1, int m, int[] array2, int n) {
		
		int mIndex = m-1;
		int nIndex = n-1;
		int kIndex = m + n - 1;
		
		//till the second array is remaining to be processed
		while(nIndex >= 0) {
			//if first array is remaining and its (current) element is greater that element (current) in second array
			if(mIndex >= 0 && array1[mIndex] > array2[nIndex]) {
				//move it to kIndex
				array1[kIndex] = array1[mIndex];
				mIndex--;
			}else {
				array1[kIndex] = array2[nIndex];
				nIndex--;
			}
			
			//shift towards left
			kIndex--;
		}
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * using merge sort algo's merge stratgey
	 * 
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 */
	public static void optiMizedSol1(int[] array1, int m, int[] array2, int n) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int mIndex = 0;
		int nIndex = 0;
		
		while(mIndex<m && nIndex<n) {
			
			if(array1[mIndex] < array2[nIndex]) {
				list.add(array1[mIndex]);
				mIndex++;
			}else {
				list.add(array2[nIndex]);
				nIndex++;
			}
			
		}
		
		while(mIndex<m) {
			list.add(array1[mIndex]);
			mIndex++;
		}
		
		while(nIndex<n) {
			list.add(array2[nIndex]);
			nIndex++;
		}
		
		for(int i = 0; i < list.size(); i++) {
			array1[i] = list.get(i);
		}
		
	}

	public static void enterNumber(int[] array1, int m, int[] array2, int n) {

		// printMe(array1);

		int count = 0;

		for (int pushArrIndex = 0; pushArrIndex < n; pushArrIndex++) {

			for (int positionToPush = 0; positionToPush < m; positionToPush++) {

				if (array1[positionToPush] > array2[pushArrIndex]) {

					for (int swap = m; swap > positionToPush; swap--) {

						array1[swap] = array1[swap - 1];
					}

					array1[positionToPush] = array2[pushArrIndex];

					m++;
					
					positionToPush++; //saves one cycle

					// printMe(array1);

					count++;

					break;

				}
			}

		}

		int newMax = m + n - count;
		if(n > 0) {
			
			for (int positionToPush = m; positionToPush < newMax; positionToPush++) {
				array1[positionToPush] = array2[count];
				count++;
				m++;
				// printMe(array1);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			if (i == m-1) {
				sb.append(array1[i]);
			} else {
				sb.append(array1[i] + ",");
			}
		}

		System.out.println(sb.toString());
	}

	public static void printMe(int array[]) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				sb.append(array[i]);
			} else {
				sb.append(array[i] + ",");
			}
		}

		System.out.println(sb.toString());
	}

}
