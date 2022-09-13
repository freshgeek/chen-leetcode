package top.chen.leetcode;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/maximum-swap/
 */
public class solution_0670 {

	public int maximumSwap(int num) {
		// 使数字最大，很容易想到把数值大的往前排，数值小的往后排，
		// 最暴力的解法： 我们要最大，那就把数字最大的排前面，保证前面的都是最大的,把数字遍历一遍，取后n位最大的出来对比即可
		// 转换思路，因为最大的数一定时按大的前，小的在后;且我们只能拿一个，所以只需要找到最大的那个数，比前方小的靠前的值交换即可
		char[] charArray = String.valueOf(num).toCharArray();
		int n = charArray.length;
		int maxIdx = n - 1;
		int idx1 = -1, idx2 = -1;
		for (int i = maxIdx; i >= 0; i--) {
			if (charArray[i] > charArray[maxIdx]) {
				maxIdx = i;
			} else if (charArray[i] < charArray[maxIdx]) {
				idx1 = i;
				idx2 = maxIdx;
			}
		}
		if (idx1 >= 0) {
			swap(charArray, idx1, idx2);
			return Integer.parseInt(new String(charArray));
		} else {
			return num;
		}
	}
	public void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}

}
