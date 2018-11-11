package General.leetCode.easy;

import java.util.Arrays;

public class TransposeMatrix {

	public static void main(String[] args) {

		int[][] matrix = new int[][] {

				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printMatrix(matrix);

		printMatrix(transposeAnyMatrix(matrix));


		System.out.println("");

		matrix = new int[][] {

				{ 1, 2, 3 }, { 4, 5, 6 } };

		printMatrix(matrix);

		printMatrix(transposeAnyMatrix(matrix));
	}

	/**
	 * only works for square matrices
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[][] transpose(int[][] matrix) {

		int rows = matrix.length;
		int columns = matrix[0].length;

		for (int x = 0; x < rows; x++) {

			for (int y = x; y < columns; y++) {

				int temp = matrix[x][y];
				matrix[x][y] = matrix[y][x];
				matrix[y][x] = temp;
			}
		}

		return matrix;
	}

	public static int[][] transposeAnyMatrix(int[][] matrix) {

		int rows = matrix.length;
		int columns = matrix[0].length;

		int[][] newMatrix = new int[columns][rows];

		for (int x = 0; x < rows; x++) {

			for (int y = 0; y < columns; y++) {
				
				newMatrix[y][x] = matrix[x][y];

			}

		}
		
		return newMatrix;

	}

	public static void printMatrix(int[][] matrix) {

		Arrays.stream(matrix).flatMap(x -> Arrays.stream(x).boxed()).forEach(System.out::print);
	}

}
