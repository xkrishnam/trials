package iitj;

import java.util.Random;

public class Graph {

	public static void gds(int mat[][], int R, int C) {
		int row[] = new int[R];
		int col[] = new int[C];
		int i, j;

		/* Initialize all values of row[] as 0 */
		for (i = 0; i < R; i++)
			row[i] = 0;

		/* Initialize all values of col[] as 0 */
		for (i = 0; i < C; i++)
			col[i] = 0;

		/* Randomly selecting 2 rows to fill 1 */
		for (i = 1; i < C; i++) {
			for (int k = 0; k < 2; k++) {
				Random random = new Random();
				int index = random.nextInt(mat.length);
				System.out.print(index);
				mat[index][C - 1] = 1;
			}
		}

	}

	/* A utility function to print a 2D matrix */
	public static void printMatrix(int mat[][], int R, int C) {
		int i, j;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = new int[50][250];

		System.out.println("Matrix Initially");
		printMatrix(mat, 50, 250);
		gds(mat, 50, 250);
		System.out.println("Matrix after");
		printMatrix(mat, 50, 250);

	}

}
