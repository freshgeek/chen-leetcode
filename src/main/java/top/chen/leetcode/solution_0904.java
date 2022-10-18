package top.chen.leetcode;

/**
 * @author chenchao
 */
public class solution_0904 {

	public int totalFruit(int[] fruits) {
		// 进阶版 显然每次都要把第i个开始的最长，那我把遍历好的下标记录下来，下次就不用计算了

	}

	public int baseTotalFruit(int[] fruits) {
		// 滑动窗口,从第i个开始，取两个的最长数
 		int max = 0;
		for (int j = 0; j < fruits.length ; j++) {
			Integer first = null;
			Integer sec = null;
			int m = j;
			for (; m < fruits.length; m++) {
				if (first == null || first == fruits[m]) {
					first = fruits[m];
				} else if (sec == null || sec == fruits[m]) {
					sec = fruits[m];
				} else {
					break;
				}
			}
			max = Math.max(m - j, max);
		}
		return max;
	}
}
