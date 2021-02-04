package simple;


/**
 * @author TT
 * @Date 2021/2/4 19:32
 * No.634
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 *
 * 提示：
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 子数组最大平均数I {

    public static void main(String[] args) {
        int nums[] = {0,4,0,3,2};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int start = 0, end = k-1, len = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<k; ++i) {
            sum += nums[i];
        }
        if (sum > max) max = sum;
        while (end < len-1){
            sum = sum - nums[start] + nums[end+1];
            if (sum > max) max = sum;
            start++;
            end++;
        }
        return (double) max/k;

    }
}
