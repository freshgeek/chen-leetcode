package top.chen.leetcode;

import java.util.Arrays;

/**
 * @author chenchao
 * @date 2022-09-20 12:50:53
 * @link https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class solution_0698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 数组 分成k个非空子集 总和相等
        // 总和可以知道为：sum(nums)/k = 子集之和m
        // 如果这里余数不为0，说明无法均分
        // 同时元素大于0，最大值比m大也无法凑齐
        // 可以想到，先排序后，双指针求和，凑齐集合使它等于m

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }
        int avg = total / k;
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        for (int i = nums.length - 1; i > 0; ) {
            for (int j = i - 1; j > 0; ) {
                if (visit[j]) {
                    j--;
                    continue;
                }
                if (visit[i]) {
                    i--;
                    continue;
                }

                if (nums[i] > avg) {
                    return false;
                } else if (nums[i] == avg) {
                    visit[i--] = true;
                } else if (nums[j] + nums[i] == avg) {
                    visit[i--] = true;
                    visit[j--] = true;
                } else if (nums[j] + nums[i] > avg) {
                    j--;
                }else if (nums[j]+nums[i]<avg){
                    // dfs

                }
            }
        }

        return false;
    }
}
