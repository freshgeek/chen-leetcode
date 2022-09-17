package top.chen.leetcode;

import org.junit.Test;

public class solution_0850Test {

	@Test
	public void testRectangleArea() {
		solution_0850 RectangleArea = new solution_0850();
		System.out.println(RectangleArea.rectangleArea(new int[][]{
				{0, 0, 2, 2},
				{1, 0, 2, 3},
				{1, 0, 3, 1}
		}));
	}
}
