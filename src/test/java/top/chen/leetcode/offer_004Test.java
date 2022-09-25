package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class offer_004Test {

	@Test
	public void testFindNumberIn2DArray() {
		offer_004 FindNumberIn2DArray = new offer_004();
		int[][] ar = new int[][]{
				{1, 4, 7, 11, 15},
				{2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30},
		};
		assertFalse(FindNumberIn2DArray.findNumberIn2DArray(new int[][]{{1, 1}}, 2));

		assertFalse(FindNumberIn2DArray.findNumberIn2DArray(new int[][]{}, 0));
		assertTrue(FindNumberIn2DArray.findNumberIn2DArray(new int[][]{
				{-1, 3}
		}, 3));
		assertTrue(FindNumberIn2DArray.findNumberIn2DArray(ar, 5));
		assertTrue(FindNumberIn2DArray.findNumberIn2DArray(ar, 10));
		assertFalse(FindNumberIn2DArray.findNumberIn2DArray(ar, 25));
		assertTrue(FindNumberIn2DArray.findNumberIn2DArray(ar, 26));

	}
}
