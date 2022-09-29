package top.chen.leetcode;

/**
 * @author chenchao
 */
public class review_01_09 {

	public boolean isFlipedString(String s1, String s2) {
		// 轮转，那么长度必然相等
		// 定长为length
		if (s1.length() != s2.length()) {
			return false;
		}
		// 所以拼接双倍s1 ， 必然包含s2
		// 不包含则不是轮转得到，同时搜索子串用kmp算法o（n）
		s1 += s1;
		return s1.contains(s2);
	}
}
