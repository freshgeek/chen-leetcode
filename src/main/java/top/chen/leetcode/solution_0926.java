package top.chen.leetcode;

import cn.hutool.core.lang.Assert;

import java.util.Arrays;

/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * <p>
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * <p>
 * 返回使 S 单调递增的最小翻转次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 * <p>
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 * <p>
 * 输入："00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 *  
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flip-string-to-monotone-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 * @date 2021-09-24 13:49:08
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class solution_0926 {

    public static void main(String[] args) {
        solution_0926 solution0926 = new solution_0926();
        Assert.isTrue(2 == solution0926.minFlipsMonoIncr("10100"));
        Assert.isTrue(1 == solution0926.minFlipsMonoIncr("00100"));
        Assert.isTrue(0 == solution0926.minFlipsMonoIncr("00111"));
        Assert.isTrue(1 == solution0926.minFlipsMonoIncr("00101"));
        Assert.isTrue(0 == solution0926.minFlipsMonoIncr("0001"));
        Assert.isTrue(1 == solution0926.minFlipsMonoIncr("1000"));
        Assert.isTrue(3 == solution0926.minFlipsMonoIncr("0101100011"));
        Assert.isTrue(5 == solution0926.minFlipsMonoIncr("10011111110010111011"));
        Assert.isTrue(0 == solution0926.minFlipsMonoIncr("111"));
    }

    /**
     * LIS 贪心算法
     */
    public int minFlipsMonoIncr(String s) {
        // 演示过程，这个问题不需要这个数组
        int[] lis = new int[s.length()];
        Arrays.fill(lis, -1);

        // 队伍的长度
        int len = 0;
        // 0放入队伍中的位置
        int i = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                lis[i] = 0;
                if (i == len) {
                    // 此时队伍中没有1
                    len++;
                }
                i++;
            } else {
                // 1放入队伍的末尾
                lis[len] = 1;
                len++;
            }
        }

        return s.length() - len;
    }
}
