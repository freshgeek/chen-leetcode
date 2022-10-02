package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class solution_0777Test {

	@Test
	public void testCanTransform() {
		solution_0777 CanTransform = new solution_0777();
		assertTrue(CanTransform.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
		assertTrue(CanTransform.canTransform("RXXLRXRXL", "XRLXXRRLX"));
		assertFalse(CanTransform.canTransform("LXXLXRLXXL", "XLLXRXLXLX"));


	}
}
