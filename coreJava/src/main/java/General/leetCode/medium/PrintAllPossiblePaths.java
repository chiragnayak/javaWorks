package General.leetCode.medium;

public class PrintAllPossiblePaths {
	
	public static int rowMax = 0;
	public static int colMax = 0;
	public static int total = 0;

	public static void main(String[] args) {
		
		int matrix [][] = createMatrix(4,4);
		
		printAllPossiblePaths(matrix, "", 0, 0);
		
		System.out.println("=========================");
		
		System.out.println("Total : "+total+" Paths ");
		
		System.out.println("=========================");

//		System.out.println(numberOfPaths(7, 3));
//		System.out.println(numberOfPathsII(7, 3));

		
	}
	
	public static int numberOfPathsII(int row, int column) {
		return -1;
	}

	public static int numberOfPaths(int row, int column) {

		// If either given row number is first or 
        // given column number is first
        if (row == 1 || column == 1) {
        	System.out.println(row+" "+column+" -> 1");
        	 return 1;
        }
           
  
        // If diagonal movements are allowed then 
        // the last addition is required.
        return  numberOfPaths(row-1, column) + numberOfPaths(row, column-1);
                // + numberOfPaths(m-1,n-1);
	}

	
	public static void printAllPossiblePaths(int [][] matrix, String base, int row, int column) {
		
		rowMax = matrix.length-1;
		colMax = matrix[0].length-1;
		
		if(row==rowMax) {
			StringBuilder sb = new StringBuilder();
			sb.append(base+" ");
			for(int i=column; i<=colMax; i++) {
				sb.append(matrix[row][i]+" ");
			}
			//System.out.println(sb.toString());
			total++;
			return;
		}
		
		if(column==colMax) {
			StringBuilder sb = new StringBuilder();
			sb.append(base+" ");
			for(int i=row; i<=rowMax; i++) {
				sb.append(matrix[i][column]+" ");
			}
			//System.out.println(sb.toString());
			total++;
			return;
		}
		
		printAllPossiblePaths(matrix, base+" "+String.valueOf(matrix[row][column]), row+1, column);
		printAllPossiblePaths(matrix, base+" "+String.valueOf(matrix[row][column]), row, column+1);
		
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
		
		printMatrix(matrix);

		return matrix;
	}

	public static void printMatrix(int[][] matrix) {

		int row = matrix.length;
		int column = matrix[0].length;

		System.out.println("=============================");

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println("");
		}

		System.out.println("=============================");

	}

}
