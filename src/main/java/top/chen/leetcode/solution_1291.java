package top.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *  
 * <p>
 * 提示：
 * <p>
 * 10 <= low <= high <= 10^9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequential-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 * @date 2021-09-23 20:52:35
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class solution_1291 {
    public static void main(String[] args) {
        solution_1291 solution1291 = new solution_1291();
        System.out.println(solution1291.sequentialDigits(56, 155));
        System.out.println(solution1291.sequentialDigits(234, 155));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret = new ArrayList<>();
        int tmp = low;
        while (tmp < high) {
            char[] value = String.valueOf(tmp).toCharArray();
            int j = Character.getNumericValue(value[0]);
            if (j + value.length <= 10) {
                tmp = 0;
                for (int i = 0;
                     i < value.length; i++, j++) {
                    tmp = tmp * 10 + j;
                }
                if (tmp >= low && tmp <= high) {
                    ret.add(tmp);
                }
            }
            tmp = tmp + getHigh(tmp);
        }
        return ret;
    }

    private int getHigh(int tmp) {
        int i = 0;
        int ret = 1;
        while (tmp > 10) {
            tmp /= 10;
            i++;
        }
        while (i > 0) {
            ret *= 10;
            i--;
        }
        return ret;
    }
}
