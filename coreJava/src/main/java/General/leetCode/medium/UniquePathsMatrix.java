package General.leetCode.medium;

public class UniquePathsMatrix {

	public static void main(String[] args) {

		System.out.println(countPaths(100, 100));
	}

	private static long countPaths(int row, int column) {

		long grid[][] = new long[row][column];

		/*
		 * in each cell we will write number of ways to reach there.
		 * 
		 */

		/*
		 * for all cells in first row each cell can be reached by one path. Hence, we
		 * can fill each cell with 1
		 */

		for (int c = 0; c < column; c++) {
			grid[0][c] = 1;
		}

		/*
		 * for all cells in first column each cell can be reached by one path. Hence, we
		 * can fill each cell with 1
		 */

		for (int r = 0; r < row; r++) {
			grid[r][0] = 1;
		}
		
		/*
		 * for all other cells, we will add paths to it from one cell above and from cell on its left.
		 * */
		
		for (int r = 1; r < row; r++) {
			for (int c = 1; c < column; c++) {
				
				grid[r][c] = grid[r-1][c] //from cell above
						+ 
				grid [r][c-1]; //from cell on left
			}
			
		}

		return grid[row-1][column-1]; // left most cell -> target

	}

	public static int[][] createMatrix(int row, int column) {

		int[][] matrix = new int[row][column];

		int index = 1;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				matrix[r][c] = index;
				index++;
			}
		}


		return matrix;
	}

}
