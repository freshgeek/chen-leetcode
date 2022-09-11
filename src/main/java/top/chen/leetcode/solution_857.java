package top.chen.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author chenchao
 * @link https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/
 */
public class solution_857 {

	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
		// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
		//工资组中的每名工人至少应当得到他们的最低期望工资。
		// 首先我们得用公式推导：
		// k个人：1-k ,某个人是i
		// 对应的质量：q[i],对应的工资期待是w[i]
		// 实际的收入是和质量成比例的，也就是假定比例是t[i] = sum(q[1]...q[k])/k
		// 那么实际的收入就比例乘自身质量：r[i] = t[i]*q[i]，题目中，必须不低于最低期望，所以r[i] >= w[i]
		// 综合可以得到 t[i]*q[i]>=w[i] 等价于 t[i] >= w[i]/q[i]
		// 而题目是为了 找k个人，给最少的钱，质量不看重；所以只需要找比例 t[i] 最大的k个人就好了
		// 第一步要算出k个人，每人的质量比就好了 w[i]/q[i] > w[j]/q[j]
		// 所以才会有w[i]*q[j]-w[j]*q[i] 的排序,还可以避免精度问题
		Integer[] sort = IntStream.range(0, quality.length).boxed().toArray(Integer[]::new);
		Arrays.sort(sort, (l, r) -> quality[r] * wage[l] - quality[l] * wage[r]);
		// 得到了质量比的排序后，有三个变量，质量、花费、最低期望：所以锁定第k人质量最高情况，k-1人质量越低，花费工资越少，然后再对比第k人的质量情况
		// 总的结果
		double res = 1e9;
		// 总的质量
		double totalq = 0.0;
		// 创建优先级队列
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
		// 取k个人的质量总和
		for (int i = 0; i < sort.length; i++) {
			int idx = sort[i];
			// 取前k-1个人 性价比高的 得到质量总和
			totalq += quality[idx];
			// 将当前质量加入优先级队列，质量低的优先
			pq.offer(quality[idx]);
			if (i >= k - 1) {
				// 剩余一个对比花费最少
				res = Math.min(res, ((double) wage[idx] / quality[idx]) * totalq);
				totalq -= pq.poll();
			}
		}
		return res;
	}
}
