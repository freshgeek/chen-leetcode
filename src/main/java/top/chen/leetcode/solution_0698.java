package top.chen.leetcode;

import java.util.Arrays;

/**
 * @author chenchao
 * @date 2022-09-20 12:50:53
 * @link https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */
public class solution_0698 {
    int[] numsField;
    int index, avg, kNum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 数组 分成k个非空子集 总和相等
        // 总和可以知道为：sum(nums)/k = 子集之和m
        // 如果这里余数不为0，说明无法均分
        // 同时元素大于0，最大值比m大也无法凑齐
        // 可以想到，先排序后，双指针求和，凑齐集合使它等于m
        // 但是左指针需要尽可能将大的匹配掉，因为小的可以多几个组成平均值，大数无法组

        //开始，预先变量存储，后面需要递归，避免传参麻烦
        numsField = nums;
        kNum = k;
        int total = 0;
        // 计算总值
        for (int x : numsField) {
            total += x;
        }
        // 平均值不等显然无法凑齐
        if (total % kNum != 0) {
            return false;
        }
        // 排序后遍历
        Arrays.sort(numsField);
        index = numsField.length; avg = total / kNum;
        return dfs(index - 1, 0, 0, new boolean[index]);
    }
    boolean dfs(int idx, int currentSum, int countK, boolean[] vis) {
        // 如果统计的k数等于预期的，完成
        if (countK == kNum) {
            return true;
        }
        // 如果当前累积已经满足平均值，接着遍历下一个数
        if (currentSum == avg) {
            return dfs(index - 1, 0, countK + 1, vis);
        }
        // 如果遍历完成，却cur不等avg
        if (idx == -1) {
            return false;
        }
        // 继续迭代，遍历查询
        for (int i = idx; i >= 0; i--) {
            // 访问过 或者 大于 显然不符合
            if (vis[i] || currentSum + numsField[i] > avg) {
                continue;
            }
            // 小于或者等于 则设为访问过
            vis[i] = true;
            // 将下一个推入，如果是符合的则返回true
            if (dfs(i - 1, currentSum + numsField[i], countK, vis)) {
                return true;
            }
            // 不符合要将恢复false ， 可能存在后续的数组使用
            vis[i] = false;
            // 当前累积值如果是0 直接返回false 说明已经没有数了
            if (currentSum == 0) {
                return false;
            }
        }
        // 最后都没有找到
        return false;
    }

}
