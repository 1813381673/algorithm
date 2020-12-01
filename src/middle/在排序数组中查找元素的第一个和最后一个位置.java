package middle;


/**
 * @author xsj
 * @Date 2020/12/1 21:22
 * No.34
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums 是一个非递减数组
 * -10^9 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return ans;
        int len = nums.length;
        int i = binarySearch(nums, target, 0, len - 1);
        // 如果查到了target  就两边扩散看看有没有与它相等的元素
        if (i != -1){
            int index = i;
            while (index >= 1 && nums[index-1] == nums[i]) --index;
            ans[0] = index;
            index = i;
            while (index < len-1 && nums[index+1] == nums[i]) ++index;
            ans[1] = index;
        }
        return ans;
    }
    // 二分查找 返回查到的元素下标 没有找到就返回-1
    public static int binarySearch(int[] nums, int target, int q, int p){
        int mid = (p+q)/2;
        int num = nums[mid];
        if (q >= p && num!=target) return -1;
        if (num == target) {
            return mid;
        } else if(num > target){
            return binarySearch(nums, target, q, mid);
        } else {
            return binarySearch(nums, target, mid+1, p);
        }
    }
}
