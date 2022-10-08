package top.chen.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenchao
 */
public class solution_0870 {

	public int[] advantageCount(int[] nums1, int[] nums2) {
		// 题目需要我们制造nums1，使更多的位数大于nums2
		// 那么就是田忌赛马，刚好超过的nums2的放对位，实在没有超过的拿最小的顶
		// 那么我们需要知道nums2的分别对位的顺序，所以构造一个index，按nums2的大小排序
		Integer[] index = new Integer[nums1.length];
		for (int i = 0; i < index.length; i++) {
			index[i] = i;
		}
		// 再排序nums1
		Arrays.sort(nums1);
		Arrays.sort(index, Comparator.comparingInt(l -> nums2[(int) l]));
		int left = 0, right = nums1.length - 1;
		for (int curr : nums1) {
 			if (curr > nums2[index[left]]) {
				nums2[index[left++]] = curr;
			} else {
				nums2[index[right--]] = curr;
			}
		}
		return nums2;
	}
}
