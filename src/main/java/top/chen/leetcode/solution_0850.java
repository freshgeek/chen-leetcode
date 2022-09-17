package top.chen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenchao
 * @link
 */
public class solution_0850 {

	public int rectangleArea(int[][] rectangles) {
		// 不考虑重合 很容易想到把区域切分为1等分的矩形，求到y轴长度，然后累加即可得到结果
		// 首先数值需要取模
		long mod = (int) 1e9 + 7;
		// 获得
		List<Integer> xList = new ArrayList<>();
		// 拿到x轴的点集合
		for (int[] info : rectangles) {
			xList.add(info[0]);
			xList.add(info[2]);
		}
		// 排序
		Collections.sort(xList);
		long ans = 0;
		// 从1开始拿到
		for (int i = 1; i < xList.size(); i++) {
			int beforeX = xList.get(i - 1), currentX = xList.get(i), len = currentX - beforeX;
			// 因为有重叠，所以可能存在
			if (len == 0) {
				continue;
			}
			// 然后拿到在这段区域内的 y轴 线段数组
			List<int[]> inYLine = new ArrayList<>();
			for (int[] info : rectangles) {
				// 如果是包含了当前这段则添加进来
				if (info[0] <= beforeX && currentX <= info[2]) {
					inYLine.add(new int[]{info[1], info[3]});
				}
			}
			// 排序，左下角没有重合则先比左下角y，如果重合则比较右上角
			Collections.sort(inYLine, (l1, l2) -> l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1]);
			// 加上总面积
			long total = 0, left = -1, right = -1;
			// 循环所有在x轴区域内的y轴线
			for (int[] yRange : inYLine) {
				// 左小角大于上一个右上角表示没有重叠
				if (yRange[0] > right) {
					// 记录x段内的总长度为右上角y减去左下角y
					total += right - left;
					// 赋值记录
					left = yRange[0];
					right = yRange[1];
				} else if (yRange[1] > right) {
					// 如果左下角小于等于上一个右上角 && 右上角大于上一个右上角则不用重复计算
					right = yRange[1];
				}
			}
			// 因为累加是延后一步，所以要再计算一下
			total += right - left;
			// 然后 x 乘 y 得到矩形
			ans += total * len;
			// 取模一下
			ans %= mod;
		}
		return (int) ans;
	}
}
