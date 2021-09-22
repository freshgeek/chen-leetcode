package top.chen.leetcode;

import junit.framework.Assert;

import java.util.Objects;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 来源：力扣（Leet Code）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "SpellCheckingInspection"})
public class solution_0020 {
	public static void main(String[] args) {
		solution_0020 solution0020 = new solution_0020();

		Assert.assertTrue(solution0020.isValid("()"));
		Assert.assertTrue(solution0020.isValid("()[]{}"));

		Assert.assertFalse(solution0020.isValid("(]"));

		Assert.assertFalse(solution0020.isValid("([)]"));


		Assert.assertTrue(solution0020.isValid("{[]}"));

		Assert.assertFalse(solution0020.isValid("(()("));


	}

	public boolean isValid(String s) {
		// 栈 或者 递归
		if (Objects.isNull(s) || s.length() <= 1 || (s.length() & 1) == 1) {
			return false;
		}
		char[] chars = s.toCharArray();
		char[] left = new char[chars.length / 2];
		int leftIndex = 0;
		for (char c : chars) {
			if (isLeft(c)) {
				if (leftIndex >= left.length) {
					return false;
				}
				left[leftIndex++] = c;
			} else if (leftIndex <= 0 || !match(left[--leftIndex], c)) {
				return false;
			}
		}

		return leftIndex == 0;
	}

	private boolean match(char c, char c1) {
		for (int i = 0; i < left.length; i++) {
			if (c == left[i] && right[i] == c1) {
				return true;
			}
		}
		return false;
	}

	char[] left = new char[]{'(', '[', '{'};
	char[] right = new char[]{')', ']', '}'};

	private boolean isLeft(char b) {
		for (char l : left) {
			if (l == b) {
				return true;
			}
		}
		return false;
	}
}
