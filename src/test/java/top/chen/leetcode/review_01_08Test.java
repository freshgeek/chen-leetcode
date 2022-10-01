package top.chen.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class review_01_08Test {

	@Test
	public void testSetZeroes() {
		review_01_08 SetZeroes = new review_01_08();
		int[][] old = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};
		SetZeroes.setZeroes(old);
		Assert.assertArrayEquals(new int[][]{
				{1, 0, 1},
				{0, 0, 0},
				{1, 0, 1}
		}, old);
	}
	@Test
	public void testSetZeroes2() {
		review_01_08 SetZeroes = new review_01_08();
		int[][] old = {
				{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}
		};
		SetZeroes.setZeroes(old);
		Assert.assertArrayEquals(new int[][]{
				{0,0,0,0},
				{0,4,5,0},
				{0,3,1,0}
		}, old);
	}
}
