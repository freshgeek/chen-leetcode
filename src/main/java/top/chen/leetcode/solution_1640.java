package top.chen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenchao
 * @date 2022-09-22 12:20:49
 * @link https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
public class solution_1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        // 不能重新排序，所以挨个尝试比较+回溯即可得到是否能组成arr
        // 循环arr每个元素，记录元素下标
        // 循环对比pieces ，再记录arr对比当前下标，并移动pieces 下标，直到数组pieces全部使用完成
        // 如果满足则下移pieces ，arr当前下标 结束 返回true
        // 全部满足则使用数组累加1
        // 如果不满足则继续下一个pieces中的数组，恢复循环中的arr下标
        // 这种方式需要很多次循环，并且可能需要在pieces中反复扫，所以拿到提示中的：
        // arr 中的整数 互不相同
        // pieces 中的整数 互不相同
        // 1 <= arr[i], pieces[i][j] <= 100
        // 我们可以构建一个pieces 索引，找到对应的下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; ) {
            Integer index = map.get(arr[i]);
            if (index == null) {
                return false;
            }
            for (int item : pieces[index]) {
                if (item != arr[i++]) {
                    return false;
                }
            }
        }
        return true;
    }
}
