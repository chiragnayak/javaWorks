package General.leetCode.medium;

/**
 * Step for DP :
 * 
 * 1) Define Sub-problem : 
 * 			for Sum at [i,j] : Sum [i-1][j] + Sum [i] [j-1]
 * 2) State recursive relation :
 * 			for MinSum [i][j] = Min (MinSum[i-1][j] + MinSum[i][j-1]) 
 * 
 * @author cnayak
 *
 */
public class MinimumPathSumMatrix {

	public static void main(String[] args) {
		
		int grid [] [] = {
				
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		
		System.out.println(minPathSum(grid));
		
		grid =  new int [][] {
				
				{1,3,1}
				
		};
		
		System.out.println(minPathSum(grid));
		
		grid =  new int [][] {
			
			{1},
			{1},
			{1}
			
	};
	
	System.out.println(minPathSum(grid));

	}

	public static int minPathSum(int[][] grid) { //63.11% solution

		int i= grid.length;
		int j = grid[0].length;
		
		//if empty matrix
		if(i==0 && j==0) {
			return grid[i][j];
		}
		
		
		int [] [] min = new int [i][j];
		
		for(int row=0; row<i; row++) {
			
			for(int col=0; col<j; col++) {
				
				int valueAtPostop=0;
				int valueAtPosLeft=0;
				
				
				if(row==0 && col == 0) {
					valueAtPostop = grid[row][col];
					valueAtPosLeft = grid[row][col];
				}else if(row==0) {
					valueAtPostop = valueAtPosLeft = grid[row][col] + min[row][col-1];
					
				}else if (col==0) {
					valueAtPosLeft = valueAtPostop = grid[row][col] + min[row-1][col];
				}else {
					valueAtPostop = grid[row][col] + min[row-1][col];
					valueAtPosLeft = grid[row][col] + min[row][col-1];
				}
				
				min [row][col] = Math.min(valueAtPostop, valueAtPosLeft);
			}
		}
		
		
		return min[min.length-1][min[0].length-1];
	}

}
