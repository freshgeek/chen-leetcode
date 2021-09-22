package top.chen.leetcode;


 import cn.hutool.json.JSONUtil;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能地相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class solution_0725 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("[");
			ListNode tmp = this;
			while (true) {
				stringBuilder.append(val);
				tmp = tmp.next;
				if (tmp == null) {
					break;
				}
				stringBuilder.append(",");
			}
			stringBuilder.append("]");
			return stringBuilder.toString();
		}
	}

	public static void main(String[] args) {
		solution_0725 solution0725 = new solution_0725();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));
		System.out.println(JSONUtil.toJsonStr(solution0725.splitListToParts(head, 3)));
	}

	public ListNode[] splitListToParts(ListNode head, int k) {
		// 提前返回
		ListNode[] nodes = new ListNode[k];
		if (head == null) {
			return nodes;
		}

		// 切割
		int[] arr = getLengthArray(head, k);

		// 循环数组，切割长度
		ListNode loop = head;
		ListNode last = null;
		for (int i = 0; i < arr.length; i++) {
			// 单个长度
			ListNode first = loop;
			if (last != null) {
				// 切断
				last.next = null;
			}
			int curr = 0;
			for (; curr < arr[i] && loop != null; curr++) {
				last = loop;
				loop = loop.next;
			}
			nodes[i] = curr == 0 ? null : first;
		}
		return nodes;
	}

	private int[] getLengthArray(ListNode head, int k) {

		// 获得长度
		int length = 0;
		ListNode next = head;
		do {
			length++;
			next = next.next;
		} while (next != null);

		int avg = length / k;
		int remain = length % k;
		int[] ret = new int[k];
		for (int i = 0; i < k; i++) {
			ret[i] = avg + (i < remain ? 1 : 0);
		}
		return ret;
	}
}
