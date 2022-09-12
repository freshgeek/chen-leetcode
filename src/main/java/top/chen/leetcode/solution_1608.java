package top.chen.leetcode;

import java.util.Arrays;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * @link
 */
public class solution_1608 {

	public int specialArray(int[] nums) {
		// 关键点：在数组nums中 刚好x个元素大于等于x 那么返回x，否则返回-1，x不需要在nums中,x存在则唯一
		// 做题时，尽量别直接想暴力解法，多想想方法，这些方法可能就是优化的方向
		// 与大小相关，那么优先想到排序
		// 排好序之后，循环时能知道i、数组长度（即可知道还剩余的元素个数）
		// 1. 但是x越小，大于等于个数越多 ，反之则越少，所以x与长度找更优，大于长度无
		// 2. 假设i个元素后有n个大于等于，等价于求i=n的值 ,那么可以存下hash映射，但是这里说唯一，因此直接返回即可,这种情况会漏掉了不在数组中的数，显然不适合
		// x肯定在[0,nums.length] 中间，而nums排好序后，可以通过二分查找到对应x的大于个数 ,所以直接通过
		Arrays.sort(nums);
		int n = nums.length;
		for (int x = 0; x <= nums.length; x++) {
			int l = 0, r = n - 1;
			while (l < r) {
				int mid = l + r >> 1;
				if (nums[mid] >= x) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if (nums[r] >= x && x == n - r) {
				return x;
			}
		}
		return -1;
	}

}
