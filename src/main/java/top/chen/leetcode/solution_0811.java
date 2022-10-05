package top.chen.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenchao
 * @see https://leetcode.cn/problems/subdomain-visit-count/
 */
public class solution_0811 {

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> count = new HashMap<>(cpdomains.length * 5);
		for (String cpdomain : cpdomains) {
			String[] split = cpdomain.split(" ");
			String sub = split[1];
			Integer pv = Integer.valueOf(split[0]);
			count.put(sub, count.getOrDefault(sub, 0) + pv);
			int indexOf = sub.indexOf(".");
			while (indexOf >= 0) {
				sub = sub.substring(indexOf + 1);
				count.put(sub, count.getOrDefault(sub, 0) + pv);
				indexOf = sub.indexOf(".");
			}
		}
		return count.entrySet().stream().map(s -> s.getValue() + " " + s.getKey()).collect(Collectors.toList());
	}


}
