package top.chen.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你`一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 * @date 2021-09-13 13:40:47
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class solution_0315 {

	/**
	 * 树状数组优化区域查询
	 */
	int[] tree;
	/**
	 * 离散数组维护索引
	 */
	int[] index;

	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return Collections.emptyList();
		} else if (nums.length == 1) {
			return Collections.singletonList(0);
		}
		initTreeAndIndex(nums);
		List<Integer> ret = new ArrayList<>(nums.length);

		for (int i = nums.length - 1; i >= 0; i--) {
			int num = nums[i];
			int position = getPosition(num);
			ret.add(queryTreeArray(position));
			// 树状数组是从1开始的，而数组下标是从0开始的
			update(position + 1);
		}
		Collections.reverse(ret);
		return ret;
	}

	private void initTreeAndIndex(int[] nums) {
		index = Arrays.stream(nums).distinct().sorted().toArray();
		tree = new int[index.length];
	}

	public int getPosition(int key) {
		return Arrays.binarySearch(index, key);
	}

	public static void main(String[] args) {
		int[] sum = {999, 5, 2, 3, 6, 2, 999, 5, 1};
		solution_0315 solution0315 = new solution_0315();
		System.out.println(solution0315.countSmaller(sum));
	}

	private void update(int i) {
		while (i < tree.length) {
			tree[i] += 1;
			i += lowBit(i);
		}
	}

	private int queryTreeArray(int position) {
		int sum = 0;
		while (position > 0) {
			sum += tree[position];
			position -= lowBit(position);
		}
		return sum;
	}

	private int lowBit(int i) {
		return i & -i;
	}
}
