package middle;


/**
 * @author TT
 * @Date 2021/2/8 9:14
 * Mo.978
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 *
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 *
 * 输入：[100]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最长湍流子数组 {

    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        if (len == 1) return 1;
        if (len == 2) return arr[0] == arr[1] ? 1 : 2;
        int ans = (arr[0] == arr[1] ? 1 : 2);
        int temp = ans;
        for (int i = 2; i < len; i++) {
            if ( (arr[i-2] < arr[i-1] && arr[i-1] > arr[i]) || (arr[i-2] > arr[i-1] && arr[i-1] < arr[i])) {
                ++temp;
                ans = Math.max(temp, ans);
            } else {
                temp = (arr[i-1] == arr[i] ? 1 : 2);
            }
        }
        return ans;
    }
}
