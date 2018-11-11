package General.leetCode.medium;

/**
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1,
 * then 3 steps to the last index. Example 2:
 * 
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index
 * 3 no matter what. Its maximum jump length is 0, which makes it impossible to
 * reach the last index.
 * 
 * 
 * @author cnayak
 *
 */
public class JumpGame {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 3, 1, 1, 4 };

		System.out.println(canJump(nums));
		System.out.println(canJumpFaster(nums));

		nums = new int[] { 3, 2, 1, 0, 4 };

		System.out.println(canJump(nums));
		System.out.println(canJumpFaster(nums));

		nums = new int[] { 3 };

		System.out.println(canJump(nums));
		System.out.println(canJumpFaster(nums));

		nums = new int[] { 2, 0 };

		System.out.println(canJump(nums));
		System.out.println(canJumpFaster(nums));

	}

	/**
	 * My approach : Dynamic Programming Bottom-up
	 * 
	 * remember each position being jumpable to destination as true/false in a
	 * seperate boolean array
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {

		if (nums == null) {
			return false;
		}

		int destIndex = nums.length - 1;

		boolean[] jumpable = new boolean[nums.length];

		// last position is reacheable
		jumpable[destIndex] = true;

		for (int position = destIndex - 1; position >= 0; position--) {

			// System.out.println(nums[position]);

			for (int iJumps = nums[position]; iJumps >= 1; iJumps--) {
				int getReach = position + iJumps;
				if (getReach <= destIndex) {
					if (jumpable[getReach]) {
						jumpable[position] = true;
						break;
					}
				}

			}
		}

		return jumpable[0];

	}

	/**
	 * App 4 : Greedy :
	 * 
	 * Once we have our code in the bottom-up state, we can make one final,
	 * important observation. From a given position, when we try to see if we can
	 * jump to a GOOD position, we only ever use one - the first one (see the break
	 * statement). In other words, the left-most one. If we keep track of this
	 * left-most GOOD position as a separate variable, we can avoid searching for it
	 * in the array. Not only that, but we can stop using the array altogether.
	 * 
	 * Iterating right-to-left, for each position we check if there is a potential
	 * jump that reaches a GOOD index (currPosition + nums[currPosition] >=
	 * leftmostGoodIndex). If we can reach a GOOD index, then our position is itself
	 * GOOD. Also, this new GOOD position will be the new leftmost GOOD index.
	 * Iteration continues until the beginning of the array. If first position is a
	 * GOOD index then we can reach the last index from the first position.
	 * 
	 * To illustrate this scenario, we will use the diagram below, for input array
	 * nums = [9, 4, 2, 1, 0, 2, 0]. We write G for GOOD, B for BAD and U for
	 * UNKNOWN. Let's assume we have iterated all the way to position 0 and we need
	 * to decide if index 0 is GOOD. Since index 1 was determined to be GOOD, it is
	 * enough to jump there and then be sure we can eventually reach index 6. It
	 * does not matter that nums[0] is big enough to jump all the way to the last
	 * index. All we need is one way.
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJumpFaster(int[] nums) {

		if (nums == null) {
			return false;
		}

		int destIndex = nums.length - 1;

		boolean[] jumpable = new boolean[nums.length];

		// last position is reacheable
		jumpable[destIndex] = true;

		int leftPivotAddressToReachDestination = destIndex;

		for (int position = destIndex - 1; position >= 0; position--) {

			if (position + nums[position] >= leftPivotAddressToReachDestination) {
				leftPivotAddressToReachDestination = position;
			}
		}

		return leftPivotAddressToReachDestination == 0;

	}

}
