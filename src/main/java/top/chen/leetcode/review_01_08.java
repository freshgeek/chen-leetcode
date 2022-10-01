package top.chen.leetcode;

/**
 * @author chenchao
 */
public class review_01_08 {
//   m x n
// 	public void setZeroes(int[][] matrix) {
//		boolean[][] zero = new boolean[matrix.length][matrix[0].length];
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				zero[i][j] = matrix[i][j] == 0;
//			}
//		}
//		for (int i = zero.length - 1; i >= 0; i--) {
//			for (int j = zero[i].length - 1; j >= 0; j--) {
//				if (zero[i][j]) {
//					setZeroesXY(matrix, i, j);
//				}
//			}
//		}
//	}
//
//	private void setZeroesXY(int[][] matrix, int i, int j) {
//		for (int i1 = matrix.length - 1; i1 >= 0; i1--) {
//			matrix[i1][j] = 0;
//		}
//		for (int j1 = matrix[i].length - 1; j1 >= 0; j1--) {
//			matrix[i][j1] = 0;
//		}
//	}

//	public void setZeroes(int[][] matrix) {
//		boolean[] row = new boolean[matrix.length];
//		boolean[] col = new boolean[matrix[0].length];
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[i].length; j++) {
//				if (matrix[i][j] == 0) {
//					row[i] = col[j] = true;
//				}
//			}
//		}
//		for (int i = matrix.length - 1; i >= 0; i--) {
//			for (int j = matrix[i].length - 1; j >= 0; j--) {
//				if (col[j] || row[i]) {
//					matrix[i][j] = 0;
//				}
//			}
//		}
//	}


	public void setZeroes(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length;
		// 起始0位是否有0
		boolean row0 = false;
		boolean col0 = false;
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				col0 = true;
				break;
			}
		}
		for (int j = 0; j < m; j++) {
			if (matrix[0][j] == 0) {
				row0 = true;
				break;
			}
		}
		// 从1位开始,归拢到0位
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = matrix[i][0] = 0;
				}
			}
		}
		// 开始遍历1判断是否需要消除
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (col0) {
			for (int i = 0; i < n; i++) {
				matrix[i][0] = 0;
			}
		}

		if (row0) {
			for (int i = 0; i < m; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}
