package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class solution_1652Test {

	@Test
	public void testDecrypt() {
		solution_1652 Decrypt = new solution_1652();
		assertArrayEquals(new int[]{12, 10, 16, 13}, Decrypt.decrypt(new int[]{5, 7, 1, 4}, 3));
		assertArrayEquals(new int[]{12, 5, 6, 13}, Decrypt.decrypt(new int[]{2, 4, 9, 3}, -2));
	}
}
