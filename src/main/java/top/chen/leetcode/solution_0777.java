package top.chen.leetcode;

/**
 * @author chenchao
 */
public class solution_0777 {

	public boolean canTransform(String start, String end) {
		// XL -> LX
		// RX -> XR
		// 首先长度剪枝
		if (start.length() != end.length()) {
			return false;
		}
		int n = start.length(); ;
		// 然后分别两个指针对start 、 end 遍历
		for (int startIndex = 0, endIndex = 0; ; startIndex++, endIndex++) {
			// 找到start 非X的字符
			while (startIndex < n && start.charAt(startIndex) == 'X') {
				++startIndex;
			}
			// 找到end 非X的字符
			while (endIndex < n && end.charAt(endIndex) == 'X') {
				++endIndex;
			}
			// 如果都遍历完了就结束成功
			if (startIndex == n && endIndex == n) {
				return true;
			}
			// 如果遍历完了，最后还不等
			if (startIndex == n || endIndex == n || start.charAt(startIndex) != end.charAt(endIndex)) {
				return false;
			}
			// 如果遍历到L 开始小于结束的索引下标（因为只能往左移）和 R 开始大于结束索引下标（只能右移）
			if (start.charAt(startIndex) == 'L' && startIndex < endIndex || start.charAt(startIndex) == 'R' && startIndex > endIndex) {
				return false;
			}
		}
	}
}
