package top.chen.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class solution_0811Test     {

	@Test
	public void testSubdomainVisits() {
		solution_0811 SubdomainVisits = new solution_0811();
		SubdomainVisits.subdomainVisits(new String[]{
				"9001 discuss.leetcode.com"
		});
		System.out.println(SubdomainVisits.subdomainVisits(new String[]{
				"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
		}));
	}
}
