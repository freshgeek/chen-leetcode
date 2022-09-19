package top.chen.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class solution_0827 {

	public int largestIsland(int[][] grid) {
		// grid.length >= 1 的矩形
		// 结果数和岛屿编号
		int result = 0, index = 2;
		// 岛屿 map
		HashMap<Integer, Integer> areasMap = new HashMap<>();
		// 遍历所有点
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// 如果遇到岛屿
				if (grid[i][j] == 1) {
					// 将编号和计算得到的数映射
					areasMap.put(index, calculateAreas(index++, grid, i, j)); // 只计算未编号的岛屿
				}
			}
		}

		// 没有岛屿，全是海洋
		if (areasMap.size() == 0) {
			return 1;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					// 把是岛屿的编号取出来
					Set<Integer> islands = getIslands(grid, i, j);
					if (islands.size() == 0) {
						continue; // 周围没有岛屿
					}
					// 把所有存在的岛屿 累加起来 比较取更大的
					result = Math.max(result, islands.stream().map(areasMap::get).reduce(Integer::sum).orElse(0) + 1);
				}
			}
		}
		// 如果结果是0
		if (result == 0) {
			// 全是岛屿，没有海洋
			return areasMap.get(2);
		}
		return result;
	}


	public int calculateAreas(int index, int[][] grid, int row, int column) {
		// dfs 并且标记已遍历的岛屿
		if (!isLegal(grid, row, column) || grid[row][column] != 1) {
			return 0;
		}
		// 记录index
		grid[row][column] = index;
		// 上下左右 深度遍历 然后加上自身
		return calculateAreas(index, grid, row + 1, column) + calculateAreas(index, grid, row - 1, column) + calculateAreas(index, grid, row, column - 1) + calculateAreas(index, grid, row, column + 1) + 1;
	}

	public boolean isLegal(int[][] grid, int row, int column) {
		return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
	}

	public Set<Integer> getIslands(int[][] grid, int row, int column) {
		Set<Integer> result = new HashSet<>();
		if (isLegal(grid, row + 1, column) && grid[row + 1][column] != 0) {
			result.add(grid[row + 1][column]);
		}
		if (isLegal(grid, row - 1, column) && grid[row - 1][column] != 0) {
			result.add(grid[row - 1][column]);
		}
		if (isLegal(grid, row, column - 1) && grid[row][column - 1] != 0) {
			result.add(grid[row][column - 1]);
		}
		if (isLegal(grid, row, column + 1) && grid[row][column + 1] != 0) {
			result.add(grid[row][column + 1]);
		}
		return result;
	}

}
