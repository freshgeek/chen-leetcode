package top.chen.leetcode;

import java.util.Arrays;

/**
 * @author chenchao
 */
public class solution_1624 {

	public int maxLengthBetweenEqualCharacters(String s) {
		// 这是一道简单题，很容易想到双指针
		// 从左右开始扫描 如果遇到相同的则是最优解
		// 但是有个问题是，两边都可以动，那么需要使用滑动窗口来写
		// 外层控制窗口大小，内层窗口左右滑动
		for (int i = s.length() - 1; i > 0; i--) {
			for (int head = 0, tail = i; tail < s.length(); head++, tail++) {
				if (s.charAt(head) == s.charAt(tail)) {
					return i - 1;
				}
			}
		}
		return -1;
	}

	public int maxLengthBetweenEqualCharacters_hash(String s) {
		// 还可以用hash表求得
		// 因为只有26个小写字母
		int[] letter = new int[26];
		Arrays.fill(letter, s.length());
		int res = -1;
		for (int i = 0; i < s.length(); i++) {
			// 转换成对应字母的int值
			int u = s.charAt(i) - 'a';
			// 对比字母最小的出现下标，赋值记录，所以前面填充就是为了记录下标
			letter[u] = Math.min(letter[u], i);
			// 拿到最小下标后和当前下标对比，得到当前字母的最大长度
			// 然后与所有的最大取最大，即可得到最大
			res = Math.max(res, i - letter[u] - 1);
		}
		return res;
	}
}
