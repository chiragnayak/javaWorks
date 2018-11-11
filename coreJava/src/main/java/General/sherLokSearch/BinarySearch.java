package General.sherLokSearch;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5 Output: 2 Example 2:
 * 
 * Input: [1,3,5,6], 2 Output: 1 Example 3:
 * 
 * Input: [1,3,5,6], 7 Output: 4 Example 4:
 * 
 * Input: [1,3,5,6], 0 Output: 0
 * 
 * @author cnayak
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		int[] xx = new int[] { 0, 1, 2, 4, 5 };

		System.out.println(findBinarySearch(xx, 0));
		System.out.println(returnPosition(xx, 0));

		System.out.println(findBinarySearch(xx, 3));
		System.out.println(returnPosition(xx, 3));

		System.out.println(findBinarySearch(xx, 7));
		System.out.println(returnPosition(xx, 7));

		xx = new int[] { 1, 3, 5, 6 };

		System.out.println(findBinarySearch(xx, 0));
		System.out.println(returnPosition(xx, 0));

		System.out.println(findBinarySearch(xx, 2));
		System.out.println(returnPosition(xx, 2));

		System.out.println(findBinarySearch(xx, 7));
		System.out.println(returnPosition(xx, 7));
	}

	public static int findBinarySearch(int[] list, int value) {

		int lower = 0;
		int upper = list.length - 1;
		int mid;

		while (lower <= upper) { //iterate till both are equal or lower is less that upper
			mid = (lower + upper) / 2;
			System.out.println(lower + " - " + upper + " - " + mid);

			if (list[mid] == value) {
				return mid;
			} else if (value < list[mid]) {
				//value lies towards left section
				upper = mid - 1;
			} else {
				//values lies towards right section
				lower = mid + 1;
			}
		}

		return -1;

	}

	public static int returnPosition(int[] nums, int target) {

		int lower = 0;
		int upper = nums.length - 1;
		int mid = 0;
		int returnVal = 0;

		while (lower <= upper) {
			mid = (lower + upper) / 2;
			System.out.println(lower + " - " + upper + " - " + mid);

			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				upper = mid - 1;
				returnVal = mid; // as it will be position of mid only. mid number is greater here
			} else {
				returnVal = lower = mid + 1; // as it will be position of mid + 1 as mid number is smaller here.
			}
		}

		return returnVal;

	}

	public int searchInsert3ms(int[] nums, int target) {
		int i = 0;
		while (i < nums.length && target > nums[i]) {
			if (target == nums[i])
				return i;
			i++;
		}
		return i;
	}

}
