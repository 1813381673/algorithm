package middle;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author TT
 * @Date 2021/3/24 8:34
 * No.456
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class oneThreeTwo {

    class Solution {
        public boolean find132pattern(int[] nums) {
            int n = nums.length;
            int[] min = new int[n];
            min[0] = nums[0];   // 第一个位置的最小数肯定就是它自己了
            // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数
            for (int i = 1; i < n; ++i) min[i] = Math.min(min[i - 1], nums[i]);
            Deque<Integer> stack = new LinkedList<>();
            // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 min[i] 且小于 nums[i] 的数
            for (int i = n - 1; i >= 0; --i) {
                if (nums[i] > min[i]) {
                    // 如果栈中的数字比 min[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                    while (!stack.isEmpty() && stack.peek() <= min[i]) stack.pop();
                    // 检查一下栈顶元素是不是满足 ai<stack.peek()<aj，如果满足就说明找到了
                    if (!stack.isEmpty() && stack.peek() < nums[i]) return true;
                    stack.push(nums[i]);
                }
            }
            // 到最后都没找到，肯定只能返回false了
            return false;
        }
    }
}
