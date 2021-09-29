
## 总结用法


- 树状数组 （范围查询总数与统计）
- 归并排序
- 贪心算法
  贪心算法(又称贪婪算法)是指,在对问题求解时,总是做出在当前看来是最好的选择。
 也就是说,不从整体最优上加以考虑,他所做出的是在某种意义上的局部最优解。
 贪心算法不是对所有回题都能得到整体最优解,关键是贪心策略的进择,逃择的贪心策略必须具备无后效性,
 即某个状态以前的过程不会影响以后的状态,只与当前状态有关
 贪心选择
贪心选择是指所求问题的整体最优解可以通过一系列局部最优的选择,即贪心选择来达到。
 这是贪心算法可行的第一个基本要素,也是贪心算法与动た规划算法的主要区别。
 贪心选择是采用从顶向下、以选代的方法做出相继选择,每做一次贪心选择就将所求问题简化为一个规模更小的子问题。
 对于一个具体问题,要确定它是否具有贪心选择的性质,我们必须证明每一步所作的贪心选择最终能得到问题的最优解。
 通常可以首先证明问题的一个整体最优解,是从贪心选择开始的,而且作了贪心选择后,原问题简化为一个规模更小的类似子问题。
 然后,用数学归纳法证明,通过每一步贪心选择,最终可得到问题的一个整体最优解。

最优子结构

当一个问题的最优解包含其子问题的最优解时,称此问题具有最优子结构性质。
 运用贪心策略在每一次转化时都取得了最优解。问题的最优子结构性质是该问题可用贪心算法或动态规划算法求解的关键特征。
 贪心算法的每一次操作都对结果产生直接影响,而动态规划则不是。
 贪心算法对每个子问题的解决方案都做出选择,不能回退;动态规划则会根据以前的选择结果对当前进行选择,有回退功能。
 动态规划主要运用于二维或三维问题,而贪心一般是一维问题。

为什么不直接求全局最优解？
1、原问题复杂度过高;
2、求全局最优解的数学模型难以建立;
3、求全局最优解的计算量过大
4、没有太大必要一定要求出全局最优解,“比较优”就可以。


    - LIS （最长非递减子序列）
        - 300
        - 926
    
- 快慢指针
- 动态规划
- 