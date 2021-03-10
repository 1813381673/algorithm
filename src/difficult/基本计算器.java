package difficult;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author TT
 * @Date 2021/3/10 9:13
 * No.224
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 基本计算器 {

    class Solution {
        public int calculate(String s) {
            int len = s.length();
            int ans = 0;
            int i = 0; // 指针作用
            Deque<Integer> stack = new LinkedList(); // 保存操作符
            int sign = 1; // 符号位：代表+  ， -1代表  -
            stack.push(sign);
            while (i < len) {
                if (s.charAt(i) == ' ') {
                    ++i;
                } else if (s.charAt(i) == '-') {
                    sign = -stack.peek();
                    ++i;
                } else if (s.charAt(i) == '+') {
                    sign = stack.peek();
                    ++i;
                } else if (s.charAt(i) == '(') {
                    stack.push(sign);
                    ++i;
                } else if (s.charAt(i) == ')') {
                    stack.pop();
                    ++i;
                } else {
                    long num = 0;
                    while (i < len && Character.isDigit(s.charAt(i))) {
                        num = num*10 + s.charAt(i) - '0';
                        ++i;
                    }
                    ans += sign * num;
                }
            }
            return ans;
        }
    }
}
