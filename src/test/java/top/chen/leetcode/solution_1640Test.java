package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author chenchao
 * @date 2022-09-22 12:44:12
 */
public class solution_1640Test {

    @Test
    public void canFormArray() {
        solution_1640 solution1640 = new solution_1640();
        assertTrue(solution1640.canFormArray(new int[]{85}, new int[][]{{85}}));
    }
}