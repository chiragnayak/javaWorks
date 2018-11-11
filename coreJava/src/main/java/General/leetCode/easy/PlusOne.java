package General.leetCode.easy;

import java.util.stream.IntStream;

/**
 * 
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 * @author cnayak
 *
 */
public class PlusOne {

	public static void main(String[] args) {

		print(plusOne(new int[] { 9, 9, 9 }));

		print(plusOne(new int[] { 1, 2, 3 }));

		print(plusOne(new int[] { 1, 2, 9 }));

		print(plusOne(new int[] { 1, 9, 9 }));

		print(plusOne(new int[] { 1, 9, 3 }));

		print(plusOne(new int[] { 9, 2, 3 }));

		print(plusOne(new int[] { 9 }));
	}

	public static void print(int[] x) {

		IntStream.of(x).forEach(System.out::print);

		System.out.println();

	}

	public static int[] plusOne(int[] digits) {

		if (digits.length == 0) {
			return digits;
		}

		int position = digits.length - 1;

		int backUpdigits[] = new int[position + 2];

		int sum = digits[position] + 1;

		int carryForward = sum / 10;
		int digitAtPosition = sum % 10;

		//from position above 0th index.
		while (position > 0 && sum >= 10) {

			digits[position] = digitAtPosition; //update the origirnal list
			backUpdigits[position + 1] = digits[position]; //copy to additional (+1 size list)

			position -= 1;

			sum = carryForward + digits[position];

			carryForward = sum / 10;
			digitAtPosition = sum % 10;

		}

		//if (last) 1th index calculation is greater than 10
		if (sum >= 10) {
			
			carryForward = sum / 10;
			digitAtPosition = sum % 10;

			//postion's current value will be 0 from last while loop iteration.
			backUpdigits[position + 1] = digitAtPosition; //will fill 1th
			backUpdigits[position] = carryForward; //will fill 0th

			return backUpdigits;

		} else {
			digits[position] = digitAtPosition;
		}

		return digits;

	}

}
