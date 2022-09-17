package top.chen.leetcode;

import java.util.Arrays;

/**
 * @author chenchao
 */
public class solution_1619 {
	public double trimMean(int[] arr) {
		Arrays.sort(arr);
		// 题目说了是20的倍数，所以不担心浮点数
		int range = arr.length / 20;
		double total = 0;
		for (int i = range; i < arr.length - range; i++) {
			total += arr[i];
		}
		return total / (arr.length - (range << 1));
	}
}
