package top.chen.leetcode;

import top.chen.leetcode.base.TreeNode;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/trim-a-binary-search-tree/
 * @link https://blog.csdn.net/qq_35530042/article/details/126800344
 */
public class solution_0669 {


	/**
	 * 二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，
	 * 或者是具有下列性质的二叉树：
	 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	 * 它的左、右子树也分别为二叉排序树。
	 * 二叉搜索树作为一种经典的数据结构，
	 * 它既有链表的快速插入与删除操作的特点，
	 * 又有数组快速查找的优势；所以应用十分广泛，
	 * 例如在文件系统和数据库系统一般会采用这种数据结构进行高效率的排序与检索操作。 [1]
	 * <p>
	 * 边界是允许的
	 * 同事二叉查找树的特性：
	 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
	 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
	 * 所以，
	 * 如果当前节点等于最大、则舍弃右节点;如果当前节点等于最小，则舍弃左节点
	 * 如果
	 */
	public TreeNode trimBST(TreeNode root, int low, int high) {

		if (root == null) {
			return root;
		}
		// 如果大于高值，只能把子节点给
		if (root.val > high) {
			return trimBST(root.left, low, high);
		} else if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}

}
