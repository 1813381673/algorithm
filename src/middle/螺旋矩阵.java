package middle;


import java.util.ArrayList;
import java.util.List;

/**
 * @author TT
 * @Date 2021/3/15 9:00
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 螺旋矩阵 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList();
            int top = 0, left = 0;
            int right = matrix[0].length - 1;
            int bottom = matrix.length - 1;
            int nums = matrix.length * matrix[0].length;
            while (nums >= 1) {
                // 从左向右遍历
                for (int i = left; i <= right && nums >= 1; i++) {
                    ans.add(matrix[top][i]);
                    --nums;
                }
                ++top;
                // 从上往下遍历
                for (int i = top; i <= bottom && nums >= 1; i++) {
                    ans.add(matrix[i][right]);
                    --nums;
                }
                --right;
                // 从右向左遍历
                for (int i = right; i >=left && nums >= 1 ; i--) {
                    ans.add(matrix[bottom][i]);
                    --nums;
                }
                --bottom;
                // 从下往上遍历
                for (int i = bottom; i >= top && nums >= 1 ; i--) {
                    ans.add(matrix[i][left]);
                    --nums;
                }
                ++left;
            }
            return ans;
        }
    }
}
