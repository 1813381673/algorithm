package difficult;


import java.util.PriorityQueue;

/**
 * @author TT
 * @Date 2021/1/2 17:07
 * No.239
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -104 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 滑动窗口的最大值 {

    // NA 超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = k-1;
        int len = nums.length;
        int size = len - k + 1;
        int[] ans = new int[size];
        int preMax = nums[startIndex];
        for (int i = 0; i < size; i++) {
            if (i == startIndex) {
                ans[i] = getMaxOfWindow(nums, startIndex, endIndex);
            } else {
                if (nums[startIndex-1] == preMax) {
                    ans[i] = getMaxOfWindow(nums, startIndex, endIndex);
                } else {
                    preMax = ans[i] = Math.max(preMax, nums[endIndex]);
                }
            }

            ++startIndex;
            ++endIndex;
        }
        return ans;
    }

    public int getMaxOfWindow(int[] nums, int p, int q){
        int max = nums[p];
        for (int i = p+1; i <= q; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }



    // 官方解法一  使用优先队列(大根堆)  每次移动时 就移除一个 然后添加一个
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        // 自定义排序规则
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> {
            return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
        });
        // 进队
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // 当取出的最大值不是在滑块部分时  移除 继续取队首 直到队首在滑块之间
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 然后赋值
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

}
