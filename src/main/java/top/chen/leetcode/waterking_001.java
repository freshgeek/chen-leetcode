package top.chen.leetcode;

import java.util.Objects;

/**
 * 某国选举，必须选票人大于半数以上全国人民
 * 全国人民一人可以投一张票
 * 判断的时候不能看票，只能借助机器(机器输入两张选票，会返回告诉你，一样/不一样)
 *
 * @author chenchao
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel", "SpellCheckingInspection"})
public class waterking_001 {
	public static void main(String[] args) {
		waterking_001 waterking001 = new waterking_001();
		String solution = waterking001.solution(new String[]{"1", "2", "2", "3", "3"});
		System.out.println(solution);

	}

	private String solution(String[] tickets) {
		if (tickets == null || tickets.length <= 0) {
			return null;
		}
		int candidate = 0;
		int hp = 0;
		for (int i = 0; i < tickets.length; i++) {
			if (hp == 0) {
				candidate = i;
				hp++;
			} else if (checkSame(tickets[candidate], tickets[i])) {
				hp++;
			} else {
				hp--;
			}
		}
		if (hp == 0) {
			return null;
		}
		hp = 0;
		for (String s : tickets) {
			if (checkSame(s, tickets[candidate])) {
				hp++;
			}
		}
		return hp > (tickets.length >> 1) ? tickets[candidate] : null;
	}

	private boolean checkSame(String a, String b) {
		return Objects.equals(a, b);
	}


}
