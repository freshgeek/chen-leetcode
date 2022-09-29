package top.chen.leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author chenchao
 */
public class review_01_02 {
	public boolean CheckPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		Map<Character, Integer> table = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			table.put(s1.charAt(i), table.getOrDefault(s1.charAt(i), 0) + 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			table.put(s2.charAt(i), table.getOrDefault(s2.charAt(i), 0) - 1);
			if (table.getOrDefault(s2.charAt(i), 0) < 0) {
				return false;
			}
		}
		return true;
	}
}
