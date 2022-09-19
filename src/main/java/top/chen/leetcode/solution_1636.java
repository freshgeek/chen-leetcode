package top.chen.leetcode;

import java.util.*;

/**
 * @author chenchao
 * @date 2022-09-19 12:24:01
 */
public class solution_1636 {

    public int[] frequencySort(int[] nums) {
        // 首先计算频率
        Map<Integer, Integer> hash = new HashMap<>(nums.length);
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        // 然后排序
        list.sort((o1, o2) -> {
            Integer fr1 = hash.get(o1);
            Integer fr2 = hash.get(o2);
            return fr1.equals(fr2) ? -Integer.compare(o1, o2) : Integer.compare(fr1, fr2);
        });

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
