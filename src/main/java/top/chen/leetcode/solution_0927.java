package top.chen.leetcode;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/three-equal-parts/
 */
public class solution_0927 {

	public int[] threeEqualParts(int[] arr) {
		// 将数字拆分三等分，二进制数相等，必然是3的倍数
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		// 特判0的情况，任意拆分都可以，但是要满足题目中的i+1<J
		if (sum == 0) {
			return new int[]{0, 2};
		}
		if (sum % 3 != 0) {
			return new int[]{-1, -1};
		}
		// 开始拆分三组：0-i 、 i-j 、 j-length-1
		// 同时我们知道二进制数相等，必然是1的数量相等，所以通过前面的sum得到partition（每份多少1）
		// 设定三个数组下标表示三段1的范围
		// 三段中，1的个数是固定的，但是不同个数的0的位置可以使数值变化，所以需要在三个下标做移动，以满足符合的下标
		int partial = sum / 3;
		int first = 0, second = 0, third = 0, cur = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				if (cur == 0) {
					first = i;
				} else if (cur == partial) {
					second = i;
				} else if (cur == 2 * partial) {
					third = i;
				}
				cur++;
			}
		}

		int len = arr.length - third;
		if (first + len <= second && second + len <= third) {
			int i = 0;
			while (third + i < arr.length) {
				if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
					return new int[]{-1, -1};
				}
				i++;
			}
			return new int[]{first + len - 1, second + len};
		}
		return new int[]{-1, -1};
	}
}
