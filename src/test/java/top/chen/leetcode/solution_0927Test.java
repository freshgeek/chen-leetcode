package top.chen.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class solution_0927Test     {

	@Test
	public void testThreeEqualParts() {
		solution_0927 ThreeEqualParts = new solution_0927();
		System.out.println(Arrays.toString(ThreeEqualParts.threeEqualParts(new int[]{1, 1, 0, 0, 1})));
	}
}
