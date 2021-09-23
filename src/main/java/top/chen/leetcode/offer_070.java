package top.chen.leetcode;

import cn.hutool.core.lang.Assert;

/**
 * 给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums =  [3,3,7,7,10,11,11]
 * 输出: 10
 *  
 * <p>
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 *  
 * <p>
 * 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/skFtm2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenchao
 * @date 2021-09-23 20:21:53
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
public class offer_070 {

    public static void main(String[] args) {
        offer_070 offer070 = new offer_070();

        Assert.isTrue(2 == offer070.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        Assert.isTrue(2 == offer070.singleNonDuplicate(new int[]{1, 1, 2}));
        Assert.isTrue(1 == offer070.singleNonDuplicate(new int[]{1, 2, 2}));
        Assert.isTrue(1 == offer070.singleNonDuplicate(new int[]{1}));

        Assert.isTrue(10 == offer070.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));

    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        final int step = 2;
        for (int i = 0; i < nums.length - 1; i += step) {
            if (nums[i] != nums[i + 1]) {
                return nums[i + 1] == nums[i + 2] ? nums[i] : nums[i + 1];
            }
        }
        return nums[nums.length - 1];
    }
}
