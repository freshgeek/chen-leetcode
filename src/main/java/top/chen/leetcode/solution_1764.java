package top.chen.leetcode;

/**
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 *
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 *
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
 *
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 *
 *  
 * groups.length == n
 * 1 <= n <= 103
 * 1 <= groups[i].length, sum(groups[i].length) <= 103
 * 1 <= nums.length <= 103
 * -107 <= groups[i][j], nums[k] <= 107
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/form-array-by-concatenating-subarrays-of-another-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenchao
 * @date 2021-09-22 10:05:31
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class solution_1764 {
    public static void main(String[] args) {
        solution_1764 solution1764 = new solution_1764();
        boolean canChoose = solution1764.canChoose(new int[][]{{1, -1, -1}, {3, -2, 0}}, new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0});
        System.out.println(canChoose);
    }

    public boolean canChoose(int[][] groups, int[] nums) {

        return true;
    }
}
