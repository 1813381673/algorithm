package simple;


/**
 * @author xsj
 * @Date 2020/12/3 8:28
 * No.204
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 计数质数 {

    public static int countPrimes(int n) {
        int ans = 0;
        if (n <= 2) return ans;
        ans = 1;
        for (int i = 3; i < n; i++) {
            if (i%2 != 0) {
                if (isPrime(i)) ++ans;
            }
        }
        return ans;
    }

    public static boolean isPrime(int n){
        int end = 1+(int)Math.pow(n,0.5);
        for (int j = 3; j < end; j+=2) {
            if (n%j == 0){
                return false;
            }
        }
        System.out.println(n+"是质数");
        return true;
    }
}
