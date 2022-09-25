package top.chen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenchao
 */
public class offer_006 {
	//	public int[] reversePrint(ListNode head) {
//		List<Integer> list = new ArrayList<>();
//		ListNode loop = head;
//		while (loop != null) {
//			list.add(0, loop.val);
//			loop = loop.next;
//		}
//		return list.stream().mapToInt(Integer::intValue).toArray();
//	}
	public int[] reversePrint(ListNode head) {
		List<Integer> list = new ArrayList<>();
		dp(head, list);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	private void dp(ListNode head, List<Integer> list) {
		if (head == null) {
			return;
		}
		dp(head.next, list);
		list.add(head.val);
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
