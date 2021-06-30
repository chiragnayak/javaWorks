package General.Algo.sorting.mergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * merge sort is stable
 * 
 * when the algorithm is said to be stable ?
 * 
 * The stability of a sorting algorithm is the property that the elements that compare
to be equal preserve their original order after sorting.
 * 
 * @author cnayak
 *
 */
public class MergeSort {
	
	public static void main(String[] args) {
		
		List<Integer> sorted = mSortUsingListTopDown(Arrays.asList(1,4,3,6,8,2,9));
		
		sorted.stream().forEach(x -> System.out.print(x+" "));
		
	}
	
	/**
	 * 
	 * top down merge sort algorithm which recursively divides the input list 
	 * into smaller sublists until the sublists are trivially sorted, 
	 * and then merges the sublists while returning up the call chain.
	 * 
	 * @param list
	 * @return
	 */
	public static List<Integer> mSortUsingListTopDown(List<Integer> list) {
		
		if(list.size()==1) {
			return list;
		}
		
		//define split point
		int mid = list.size()/2;
		
		List<Integer> left = new ArrayList<>() ;
		List<Integer> right = new ArrayList<>();
		
		//fill the sub lists
		int pos = 0;
		while(pos<list.size()) {
			if(pos<mid) {
				left.add(list.get(pos));
			}else {
				right.add(list.get(pos));
			}
			
			pos++;
		}
		
		//recursive call to split and sort them
		left = mSortUsingListTopDown(left);
		right = mSortUsingListTopDown(right);
		
		//final merge
		List<Integer> result = merge(left, right);
		
		return result;
	}

	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		final int FIRST_POS = 0;
		
		//compare and push to result
		while(!left.isEmpty() && !right.isEmpty()) {
			
			if(left.get(FIRST_POS) > right.get(FIRST_POS)) {
				result.add(right.get(FIRST_POS));
				right.remove(FIRST_POS); //ArrayList with shift automatically (i.e. 0th position will be filled with previous 1th position if present)
			}else {
				result.add(left.get(FIRST_POS));
				left.remove(FIRST_POS);
			}
			
		}
		
		//push the remaining ones 
		while(!left.isEmpty()) {
			result.add(left.get(FIRST_POS));
			left.remove(FIRST_POS);
		}
		
		//push the remaining ones
		while(!right.isEmpty()) {
			result.add(right.get(FIRST_POS));
			right.remove(FIRST_POS);
		}
		
		//note : only either of two while() created to push remaining ones will be called.
		return result;
		
	}
	
	
	/*
	 * bottom up merge sort algorithm which uses a small fixed size array of references to nodes, 
	 * where array[i] is either a reference to a list of size 2 i or 0. node is a reference or pointer to a node. 
	 * 
	 * The merge() function would be similar to the one shown in the top down merge lists, 
	 * it merges two already sorted lists, and handles empty lists. 
	 * 
	 * In this case, merge() would use node for its input parameters and return value.
	 * 
	 * */
	
}
