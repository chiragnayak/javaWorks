package General.Algo.sorting.quickSort;

import java.util.stream.IntStream;

/**
 * 
 * Instead, we have  to cut the array in such a way (at pivot) that all the elements in the left part are less than all
the elements in the right part.

We first choose the last element and call it pivot.

We start comparing with the first element and move on. The moment we find an inversion, we swap the pivot with that element
and keep comparing in the opposite direction. 

We continue this way, swapping every time there is an inversion and reversing the direction of comparison each time.

We stop when all the elements have been compared. 

Note that after this process, all the elements less than the pivot are on its left, and all the elements greater than the
pivot are on its right.

Quicksort is not stable

when the algorithm is said to be stable ?
 * 
 * The stability of a sorting algorithm is the property that the elements that compare
to be equal preserve their original order after sorting.
 * 

Worst-case performance: O(n2)
Best-case performance: O(n log n)
Average performance: O(n log n)

 * @author cnayak
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		
		int [] array = new int [] {9,1,4,2,1,5,99,33,2};
		
		quickSortRightMostElementIsPivot(array, 0, array.length);
		
		IntStream.of(array).mapToObj(s -> String.valueOf(s)+",").forEach(System.out::print);
	}
	
	public static void quickSortRightMostElementIsPivot(int [] array, int start, int end) {
		
		if(end - start <= 0) {
			return;
		}
		
		int leftMostBound = start;
		int rightMostBound = end-1; //pivot in this case
		
		boolean direction = true;
		//direction true : compare towards left
		//direction false : compare towards right
		
		//till leftModeBound and rightMostBound indexs come to correct position of pivot
		//do not put <=, else it will be infinite loop (StackOverFlow)
		while(leftMostBound < rightMostBound) {
			
			if(array[leftMostBound] > array[rightMostBound] ) {
				
				int temp = array[leftMostBound];
				array[leftMostBound] = array[rightMostBound];
				array[rightMostBound] = temp;
				
				direction = !direction; //toggle direction 
				//direction is toggled becuase after swap the elements in currect direction are correctly placed (greater or smaller) and compared as well
				/*
				 *  For ex : Suppose we start comparing from the left. After the first swap, the pivot is at the
					position of the element that was found to be greater than it. All the elements that
					were on the left of it have already been compared with the pivot and found to be
					less than it. The previous figure shows the parts that have already been compared.
					Now it starts comparing from its earlier position in the opposite direction.
				 * 
				 * */
			}else {
				
				if(direction) {
					leftMostBound++;
				}else {
					rightMostBound--;
				}
			}
			
			//call quick sort for left side of the pivot
			quickSortRightMostElementIsPivot(array, start, leftMostBound);
			
			//call quick sort for right side of the pivotS
			quickSortRightMostElementIsPivot(array, leftMostBound+1, end);
		}
		
		
	}

}
