package difficult;


/**
 * @author xsj
 * @Date 2020/12/2 17:21
 * No.321
 *
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 *
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 *
 * 示例 1:
 *
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * 示例 2:
 *
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * 示例 3:
 *
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/create-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 拼接最大数 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
        maxSubsequence(nums, k);
    }


    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ( len1 + len2 < k) return null;
        int[] ans = new int[k];
        int start = Math.max(0, k - len1), end = Math.min(k, len2);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0,ans, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, ans, 0, k);
            }
        }
        return ans;
    }
    // 合并两个数组  谁大先放谁
    public static int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    // 单调栈 求一个数组的子序列长度为k的最大子序列
    public static int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        // 还有多少个候选值
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                // 每次回退一个  候选值就要补上一个  所以候选值减一
                top--;
                remain--;
            }
            if (top < k - 1) {
                // 如果栈没有满  就放入值
                stack[++top] = num;
            } else {
                // 如过栈满了 说明这个值与最后一个值一样小  并且是候选值 所以继续向后遍历 候选值减一
                remain--;
            }
        }
        return stack;
    }

    public static int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            // 比较这两个值  如果 前者与后者不相等 则 直接返回 差值
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            // 如果两个值相同 则继续向后比较
            index1++;
            index2++;
        }
        // 如果两者的前缀完全相同 则返回两者的位数差值
        return (x - index1) - (y - index2);
    }

}
