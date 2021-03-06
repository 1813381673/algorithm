package difficult;


/**
 * @author TT
 * @Date 2021/3/17 9:45
 * No.115
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * 示例 2：
 *
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 *  
 *
 * 提示：
 *
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 不同的子序列 {

    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();
            if (m < n) return 0;
            int[][] dp = new int[m+1][n+1];
            // dp[i][j]  表示 s下标从i开始的字符串 中出现 t下标从j开始的字符串  的个数
            // t下标是n时  是空字符串  
            for (int i = 0; i <= m; i++) {
                dp[i][n] = 1;
            }
            for (int i = m-1; i >= 0; i--) {
                char cs = s.charAt(i);
                for (int j = n-1; j >=0; j--) {
                    char ct = t.charAt(j);
                    if (cs == ct) {
                        dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i+1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }

}
