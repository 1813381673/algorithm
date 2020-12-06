package middle;


import java.util.Arrays;

/**
 * @author xsj
 * @Date 2020/12/6 10:47
 * No.5618
 *
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 *
 * 返回你可以对数组执行的最大操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4], k = 5
 * 输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 * - 移出 1 和 4 ，之后 nums = [2,3]
 * - 移出 2 和 3 ，之后 nums = []
 * 不再有和为 5 的数对，因此最多执行 2 次操作。
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,3], k = 6
 * 输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 * - 移出前两个 3 ，之后nums = [1,4,3]
 * 不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^9
 */
public class K和数对的最大数目 {
    public static int maxOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        // 排序后 k比第一个数还小 直接返回
        if (k < nums[0]) return ans;
        int len = nums.length;
        int index = len-1;
        while (index >=0 && nums[index] >= k) index--;
        // 此时数组之前的元素 都比K小
        // 双指针  从 nums[0] ----  nums[index] 中找何为k的两个数 然后向中间逼近
        int start = 0;
        while (start < index){
            int sum = nums[start] + nums[index];
            if (sum < k) {
                start++; // 说明前面的值太小了 需要更大的值
            } else if (sum == k){ // 结果加一 双指针同时向中间逼近
                ans++;
                start++;
                index--;
            } else { // 说明后面的值太大了 需要向前移动
                index--;
            }
        }
        return ans;

    }

}
