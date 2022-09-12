package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class solution_1608Test {

	@Test
	public void testSpecialArray() {
		solution_1608 SpecialArray = new solution_1608();
		assertEquals(-1, SpecialArray.specialArray(new int[]{1,3,9,5,11,2,11,0,4,2}));
		assertEquals(2, SpecialArray.specialArray(new int[]{3, 5}));
		assertEquals(-1, SpecialArray.specialArray(new int[]{0, 0}));
		assertEquals(3, SpecialArray.specialArray(new int[]{0, 4, 3, 4, 0}));
		assertEquals(-1, SpecialArray.specialArray(new int[]{3, 6, 7, 7, 0}));
	}
}
