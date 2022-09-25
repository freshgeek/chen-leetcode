package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class offer_005Test     {

	@Test
	public void testReplaceSpace() {
		offer_005 ReplaceSpace = new offer_005();
		assertEquals("We%20are%20happy.", ReplaceSpace.replaceSpace("We are happy."));
	}
}
