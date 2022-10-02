package top.chen.leetcode;

/**
 * @author chenchao
 */
public class solution_1694 {

	public String reformatNumber(String number) {
		number = number.replace("-", "").replace(" ", "");
		int length = number.length();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; ) {
			if (length - i > 4) {
				stringBuilder.append(number, i, i + 3).append('-');
				i += 3;
			} else if (length - i == 4) {
				stringBuilder.append(number, i, i + 2).append('-').append(number, i + 2, i + 4);
				i += 4;
			} else if (length - i == 3) {
				stringBuilder.append(number, i, i + 3);
				i += 3;
			} else if (length - i == 2) {
				stringBuilder.append(number, i, i + 2);
				i += 2;
			}
		}
		return stringBuilder.toString();
	}
}
