package top.chen.leetcode;

/**
 * @author chenchao
 */
public class offer_004 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		// 其实这个题，将矩阵旋转就是二叉搜索树
		// 可以利用二叉搜索树的特性，左小 右大
		// 从[j][0] 开始
		// 	如果大则往左，小则往右
		if (matrix.length == 0) {
			return false;
		}
		for (int m = 0, n = matrix[0].length - 1; n >= 0 && m < matrix.length; ) {
			if (matrix[m][n] == target) {
				return true;
			} else if (matrix[m][n] > target) {
				n--;
			} else if (matrix[m][n] < target) {
				m++;
			}
		}
		return false;
	}
}
