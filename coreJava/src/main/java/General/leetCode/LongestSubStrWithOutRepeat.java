package General.leetCode;

import java.util.ArrayList;

/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubStrWithOutRepeat {

	public static void main(String[] args) {

		LongestSubStrWithOutRepeat ll = new LongestSubStrWithOutRepeat();

		Solution sol = ll.new Solution();

		System.out.println(sol.lengthOfLongestSubstring("dvdf"));
	}

	class Solution {
		public int lengthOfLongestSubstring(String s) {

			// traverse the input from left to right
			// add each character in a list
			// before each addition check if the list contains it
			// if yes,
			// --- update max,
			// --- reset the list, add all characters from (first index of repeated
			//     character) + 1, to current char,
			// then add current char to list
			// if no, continue adding to list
			// at the end return the length

			char[] charArray = s.toCharArray();

			ArrayList<Character> list = new ArrayList<>();

			int max = 0;

			for (char curr : charArray) {

				if (list.contains(curr)) {
					int temp = list.size();
					if (temp > max) {
						max = temp;
					}
					
					//re-initilize the list from valid set
					ArrayList<Character> tempList = new ArrayList<>();
					
					for (int x = list.indexOf(curr) + 1; x < list.size(); x++) {
						tempList.add(list.get(x));
					}

					list = tempList;
				}

				list.add(curr);

			}

			int temp = list.size();
			if (temp > max) {
				max = temp;
			}

			return max;

		}
	}

}
