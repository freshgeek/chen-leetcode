package top.chen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchao
 */
public class solution_0904 {

	public int totalFruit(int[] fruits) {
		Map<Integer, Integer> key = new HashMap<>();
		int max = 0;
		int left = 0;
		for (int j = 0; j < fruits.length; j++) {
			key.put(fruits[j], key.getOrDefault(fruits[j], 0) + 1);
			while (key.size() > 2) {
				key.put(fruits[left], key.get(fruits[left]) - 1);
				if (key.get(fruits[left]) <= 0) {
					key.remove(fruits[left]);
				}
				left++;
			}
			max = Math.max(j - left + 1, max);
		}
		return max;
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
