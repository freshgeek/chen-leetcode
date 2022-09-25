package top.chen.leetcode;

/**
 * @author chenchao
 */
public class solution_0788 {

	public int rotatedDigits(int n) {
		// 好数 旋转之后不是数本身
		// 旋转之后不能是无效数字，那么包含347必然不是好数
		// 翻转不存在无效数字，且包含2569则为好数
		int ans = 0;
		for (int i = 1; i < n; i++) {
			boolean valid = false;
			int mod = i;
			while (mod > 0) {
				int t = mod % 10;
				mod /= 10;
				if (t == 2 || t == 5 || t == 6 || t == 9) {
					valid = true;
				} else if (t != 0 && t != 1 && t != 8) {
					valid = false;
					break;
				}
			}
			if (valid) {
				ans++;
			}
		}
		return ans;
	}

}
