package top.chen.leetcode;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/defuse-the-bomb/
 */
public class solution_1652 {

	public int[] decrypt(int[] code, int k) {
		// 循环解密，很简单
		// 分三种情况
		if (k == 0) {
			return new int[code.length];
		}
		int[] ret = new int[code.length];
		int left = k > 0 ? 1 : code.length + k;
		int right = k > 0 ? k : code.length - 1;
		int last = 0;
		for (int i = left; i <= right; i++) {
			last += code[i];
		}
		for (int i = 0; i < code.length; i++) {
			ret[i] = last;
			last -= code[(i + left) % code.length];
			last += code[(i + right + 1) % code.length];
		}
		return ret;
	}

}
