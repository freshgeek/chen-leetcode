package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class solution_1694Test       {

	@Test
	public void testReformatNumber() {
		solution_1694 ReformatNumber = new solution_1694();
		assertEquals("12", ReformatNumber.reformatNumber("12- "));
		assertEquals("123", ReformatNumber.reformatNumber("123- "));
		assertEquals("12-34", ReformatNumber.reformatNumber("12 3-4"));
		assertEquals("123-45", ReformatNumber.reformatNumber("12 3-4-5"));
		assertEquals("123-456", ReformatNumber.reformatNumber("12-34-56"));
		assertEquals("123-45-67", ReformatNumber.reformatNumber("1-234 567"));
	}
}
