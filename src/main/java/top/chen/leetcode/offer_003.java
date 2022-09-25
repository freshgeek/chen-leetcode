package top.chen.leetcode;

public class offer_003 {
	public int findRepeatNumber(int[] nums) {
		// 原地交换解法
		// 因为题目是长度n的数组，数值在0 - n-1，所以可以直接复用数组的空间，达到o1
		// 则需要假定索引值等于值
		for (int i = 0; i < nums.length; ) {
			if (nums[i] == i) {
				// 如果索引和值相等则
				i++;
				continue;
			}
			// 如果值已经有索引值对应，说明重复了
			if (nums[i] == nums[nums[i]]) {
				return nums[i];
			}
			// 如果不等，则把交换一下
			int tmp = nums[i];
			nums[i] = nums[tmp];
			nums[tmp] = tmp;
		}
		return -1;
	}
}
