package top.chen.leetcode;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
public class offer_051 {

	public static void main(String[] args) {
		offer_051 offer051 = new offer_051();
		int pairs = offer051.reversePairs(new int[]{7, 5, 6, 4});
		System.out.println(pairs);
	}

	int[] tree;
	int[] index;

	public int reversePairs(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		init(nums);
		int sum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int position = getPosition(nums[i]);
			sum += queryTreeSum(position);
			updateTree(position + 1);
		}
		return sum;
	}

	private void updateTree(int position) {
		while (position < tree.length) {
			tree[position] += 1;
			position += lowBit(position);
		}
	}

	private int lowBit(int position) {
		return position & -position;
	}

	private int queryTreeSum(int position) {
		int sum = 0;
		while (position > 0) {
			sum += tree[position];
			position -= lowBit(position);
		}
		return sum;
	}

	private int getPosition(int num) {
		return Arrays.binarySearch(index, num);
	}

	private void init(int[] nums) {
		index = Arrays.stream(nums).distinct().sorted().toArray();
		tree = new int[index.length];
	}
}
