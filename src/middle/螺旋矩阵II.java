package middle;


/**
 * @author TT
 * @Date 2021/3/16 8:55
 * No.59
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 螺旋矩阵II {

    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int start = 1;
            int end = n*n;
            int left = 0, top = 0;
            int right = n-1, bottom = n-1;
            while (start <= end) {
                // 从左向右遍历
                for (int i = left; i <= right && start <= end; i++) {
                    ans[top][i] = start++;
                }
                top++;
                // 从上往下遍历
                for (int i = top; i <= bottom && start <= end; i++) {
                    ans[i][right] = start++;
                }
                right--;
                // 从右向左遍历
                for (int i = right; i >= left && start <= end; i--) {
                    ans[bottom][i] = start++;
                }
                bottom--;
                // 从下往上遍历
                for (int i = bottom; i >= top && start <= end; i--) {
                    ans[i][left] = start++;
                }
                left++;
            }
            return ans;
        }
    }
}
