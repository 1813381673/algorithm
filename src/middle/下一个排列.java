package middle;


import java.util.Arrays;

/*
 *@author xsj
 *@Date 2020/11/10 16:17
 *No.31
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 下一个排列 {
    /*
    * 题目意思：将所给的数组重新排列成一个数  这个数刚好比所给的数大一点  他俩之间不能有其他排列的数
    * 如果找不到这个数  就返回升序数组
    * */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int index = 0;
        int end = nums.length-1;
        while (index<nums.length-1 && nums[index] >= nums[index+1]) ++index;
        if (index == nums.length-1){//如果这个数组是降序排列  它已经是最大的数了 没有数比他大  定义双指针  交换首尾就可以原地操作
            index = 0;
            while (index < end){
                int temp = nums[index];
                nums[index++] = nums[end];
                nums[end--] = temp;
            }
            return;
        } else {
            end = nums.length-1;
            //从数组后面遍历 找到第一个非递减数
            while (end>0 && nums[end-1] >= nums[end]) --end;
            --end;//需要再减一下才能拿到  因为 nums[end-1] < nums[end]  我们需要的是end-1;
            index = nums.length-1;
            //找到第一个比 非递减数大的数  例如 1 2 3 4 3 4 5 2 1
            //上一步找到的数是4        这一步需要找到的是5
            while (index>end && nums[index] <= nums[end]) --index;
            //交换这两个数  然后把 end之后的数增序排列（反转）
            int temp = nums[end];
            nums[end] = nums[index];
            nums[index] = temp;
            index = nums.length-1;
            ++end;//end ----末尾的元素 进行反转  因为根据特征他们是有序的 首尾交换即可
            while (end < index){
                int temp2 = nums[index];
                nums[index--] = nums[end];
                nums[end++] = temp2;
            }
            return;
        }
    }
}
