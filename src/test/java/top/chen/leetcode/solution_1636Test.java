package top.chen.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author chenchao
 * @date 2022-09-19 12:40:36
 */
public class solution_1636Test {

    @Test
    public void frequencySort() {
        solution_1636 solution1636 = new solution_1636();
        Assert.assertArrayEquals(new int[]{1, 3, 3, 2, 2}, solution1636.frequencySort(new int[]{2, 3, 1, 3, 2}));
        Assert.assertArrayEquals(new int[]{3, 1, 1, 2, 2, 2}, solution1636.frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
        Assert.assertArrayEquals(new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}, solution1636.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}));
    }
}