package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class solution_0857Test {

	@Test
	public void testMincostToHireWorkers() {

		solution_0857 MincostToHireWorkers = new solution_0857();
		assertEquals((Double) 30.666666666666664, (Double) MincostToHireWorkers.mincostToHireWorkers(
				new int[]{3,1,10,10,1}, new int[]{4,8,2,2,7}, 3));
	}
}
