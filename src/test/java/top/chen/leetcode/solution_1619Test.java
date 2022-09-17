package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class solution_1619Test     {

	@Test
	public void testTrimMean() {
		solution_1619 TrimMean = new solution_1619();
		System.out.println(TrimMean.trimMean(new int[]{6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4}));
		System.out.println(TrimMean.trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
	}
}
