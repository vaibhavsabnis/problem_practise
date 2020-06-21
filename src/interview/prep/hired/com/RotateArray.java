package interview.prep.hired.com;

public class RotateArray {
	public static long[][] rotate90Clockwise(long[][] matrix) {
		// Type your solution here
		int size = matrix.length;
		// max cycles should be size/2
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size - i - 1; j++) {
				long temp = matrix[i][j];
				matrix[i][j] = matrix[size - 1 - j][i];
				matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
				matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
				matrix[j][size - 1 - i] = temp;
			}
		}
		return matrix;
	}

/*
	static int N = 4;
	// Function to rotate the matrix 90 degree clockwise
	static void rotate90Clockwise(int a[][]) {

		// Traverse each cycle
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {

				// Swap elements of each cycle
				// in clockwise direction
				int temp = a[i][j];
				a[i][j] = a[N - 1 - j][i];
				a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
				a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
				a[j][N - 1 - i] = temp;
			}
		}
	}
*/
	// Function for print matrix
	static void printMatrix(long arr[][]) {
		int N = arr.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		long arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate90Clockwise(arr);
		printMatrix(arr);
	}
}
