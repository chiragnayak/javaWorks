package General.leetCode.medium;

public class UniquePathsWithObstacleMatrix {

	public static void main(String[] args) {
		
		int grid[][] = new int[3][3];
		
		//obstacle at (1,1)
		grid[1][1]=1;

		System.out.println(uniquePathsWithObstacles(grid));
		
	}

	 public static int uniquePathsWithObstacles(int[][] grid) {
	        
	        int column = grid[0].length;
			int row = grid.length;
			
			
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < column; c++) {
					if(grid[r][c]==1) {
						grid[r][c]= -111;
					}
				}
			}

			/*
			 * in each cell we will write number of ways to reach there.
			 * 
			 */

			/*
			 * 
			 * horizontal case
			 * 
			 * for all cells in first row each cell can be reached by one path.
			 * but, if any column cell in this is an obstacle then all cell beyond that  cell will also be zero (inaccessible)
			 * 
			 */

			boolean foundObsInRow = false;
			for (int r =0, c = 0; c < column; c++) {
				if(grid[r][c]==-111) {
					foundObsInRow=true;
				}else {
					if(foundObsInRow) {
						grid[r][c] = 0;
					}else {
						grid[r][c] = 1;
					}
				}
			}
			

			/*
			 * vertical case --> 
			 * 
			 * for all cells in first column each cell can be reached by one path.
			 * but, if any row cell in this is an obstacle then all cell beyond that cell  will also be zero (inaccessible)
			 * 
			 */
			
			boolean foundObsInCol = false;
			for (int c =0, r = 0; r < row; r++) {
				if(grid[r][c]==-111) {
					foundObsInCol=true;
					grid[r][c] = -111;
				}else {
					if(foundObsInCol) {
						grid[r][c] = 0;
					}else {
						grid[r][c] = 1;
					}
				}
			}

					
			/*
			 * for all other cells, we will add paths to it from one cell above and from cell on its left.
			 * */
			
			for (int r = 1; r < row; r++) {
				for (int c = 1; c < column; c++) {
					
					if(grid[r][c]==-111) {
						continue;
					}
					
					int valAbove = 0;
					int valLeft = 0;
					
					if(grid[r-1][c]!=-111) {
						valAbove = grid[r-1][c];
					}
					
					if(grid [r][c-1]!=-111) {
						valLeft = grid [r][c-1];
					}
					
					grid[r][c] =valAbove //from cell above
							+ 
							valLeft; //from cell on left
				}
				
			}

			return (grid[row-1][column-1]==-111 ? 0 : grid[row-1][column-1]); // left most cell -> target
	       
	 }


}
