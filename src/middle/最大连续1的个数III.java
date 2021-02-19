package middle;


/**
 * @author TT
 * @Date 2021/2/19 9:15
 * No.1004
 *
给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。



示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释：
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。


提示：

1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1
 */
public class 最大连续1的个数III {

    public int longestOnes(int[] A, int K) {
        int ans = 0;
        int left = 0;
        int zeroSize = 0; // 记录改变0的次数
        for (int i = 0; i < A.length; i++) {
            zeroSize += (A[i] == 0 ? 1 : 0); // 如果是0 就++
            while (zeroSize > K) { // 改变零的次数耗尽了 就移动左边界 直到找到0为止;
                zeroSize -= (A[left] == 0 ? 1 : 0);
                ++left;
            }
            ans = Math.max(ans, i - left + 1); // 更新答案
        }
        return ans;
    }
}
