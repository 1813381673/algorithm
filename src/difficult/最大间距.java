package difficult;


import java.util.Arrays;

/**
 * @author xsj
 * @Date 2020/11/26 10:56\
 * No.164
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 * 通过次数28,369提交次数48,102
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最大间距 {

    public static void main(String[] args) {
        int[] nums = {80, 14, 8, 92, 26, 73, 41, 67, 33};
        System.out.println(Arrays.toString(nums));
        maximumGap2(nums);
    }

    public int maximumGap(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length < 2) return ans;
        Arrays.sort(nums);
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            max = Math.max(nums[i+1]-nums[i], max);
        }
        return max;
    }
    // 官方方法一  基数排序   个人感觉 创建临时数组  数据值和数据量比较大时  并不会节省时间 不见得哪个跑得快 虽然时间复杂度低
    public static int maximumGap2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            System.out.println("----------------------------------");
            System.out.println("exp = " + exp);
            // 各个桶的个数
            System.out.println(Arrays.toString(cnt));
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            // 修改位置后
            System.out.println(Arrays.toString(cnt));
            // for (int i = n-1; i >= 0; i--) 从后往前遍历 跟下面有什么区别？  我没发现区别
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.out.println(Arrays.toString(buf));
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

}
