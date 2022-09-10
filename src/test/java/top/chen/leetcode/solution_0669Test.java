package top.chen.leetcode;

import org.junit.Assert;
import org.junit.Test;
import top.chen.leetcode.base.TreeNode;

public class solution_0669Test {

	@Test
	public void testTrimBST() {
		solution_0669 TrimBST = new solution_0669();
		TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(2));
		Assert.assertEquals(new TreeNode(1, null, new TreeNode(2)), TrimBST.trimBST(root, 1, 2));
	}

	@Test
	public void testTrimBST_17() {
		solution_0669 TrimBST = new solution_0669();
		TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
		Assert.assertEquals(new TreeNode(3, new TreeNode(2, new TreeNode(1), null), null), TrimBST.trimBST(root, 1, 3));
	}
}
