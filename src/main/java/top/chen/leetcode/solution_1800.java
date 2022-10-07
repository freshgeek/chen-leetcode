package top.chen.leetcode;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 */
public class solution_1800 {

	public int maxAscendingSum(int[] nums) {
		// 典型的动态规划题目
		// 第一步转化公式：
		int result = 0;
		for (int i = 0; i < nums.length; ) {
			int sum = nums[i++];
			while (i < nums.length && nums[i - 1] < nums[i]) {
				sum += nums[i++];
			}
			result = Math.max(sum, result);
		}
		return result;
	}
}
