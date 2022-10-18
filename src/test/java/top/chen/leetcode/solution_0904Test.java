package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class solution_0904Test     {

	@Test
	public void testTotalFruit() {
		solution_0904 TotalFruit = new solution_0904();
		assertEquals(4, TotalFruit.totalFruit(new int[]{1,2,3,2,2}));
		assertEquals(5, TotalFruit.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
		assertEquals(3, TotalFruit.totalFruit(new int[]{0,1,2,2}));
		assertEquals(3, TotalFruit.totalFruit(new int[]{1,2,1}));
		assertEquals(2, TotalFruit.totalFruit(new int[]{1,1}));
	}
}
