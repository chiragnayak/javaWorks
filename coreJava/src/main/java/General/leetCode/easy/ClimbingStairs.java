package General.leetCode.easy;

public class ClimbingStairs {

	public static void main(String[] args) {

		for (int x = 1; x < 7; x++) {
			System.out.println("For " + x + " stairs :" + climbStairs(x) + " " + climbStairsII(x));
		}

	}

	/**
	 * 
	 * One can reach ith step in one of the two ways:
	 * 
	 * Taking a single step from (i−1)th step.
	 * 
	 * Taking a step of 22 from (i-2)th step.
	 * 
	 * So, the total number of ways to reach ith is equal to sum of ways of reaching
	 * (i−1)th step and ways of reaching (i-2)th step.
	 * 
	 * @param n
	 * @return
	 */
	private static int climbStairsII(int n) {

		int stairs[] = new int[n + 1];

		stairs[0] = 1;
		stairs[1] = 1;

		/*
		 * logic is : to come to nth step, we need to consider combinations of
		 * combinations to reach n-1 ( if reaching by taking 1 step), n-2 (if reaching
		 * by taking 2 step), n-3 (if reaching by taking three steps).. and so on
		 */
		for (int stair = 2; stair <= n; stair++) {
			stairs[stair] = stairs[stair - 1] + // if reaching by taking 1 step
					stairs[stair - 2]; // if reaching by taking 2 step

			// ... and so on depends on how many steps are allowed to be taken
		}

		return stairs[n];
	}

	public static int climbStairs(int n) {

		int total = 0;

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		if (n > 2) {
			total = total + climbStairs(n - 1);
			total = total + climbStairs(n - 2);
		} else if (n == 2) {
			total = total + climbStairs(n - 1);
			total = total + 1;
		} else {
			total = total + climbStairs(n - 1);
		}

		return total;

	}

}
