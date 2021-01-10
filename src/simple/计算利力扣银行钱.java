package simple;


/**
 * @author TT
 * @Date 2021/1/9 22:31
 * No.5633
 *
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：10
 * 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * 示例 2：
 *
 * 输入：n = 10
 * 输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * 示例 3：
 *
 * 输入：n = 20
 * 输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 */
public class 计算利力扣银行钱 {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int weekNums = n / 7;
        int ans = 0;
        if (weekNums == 0) {
            for (int i = 1; i <= n; i++) {
                ans += i;
            }
            return ans;
        }
        int basic = 0;
        for (int i = 1; i <= 7; i++) {
            basic += i;
        }
        int size = 0;
        for (int i = 1; i <= weekNums-1; i++) {
            size += i;
        }
        ans += basic * weekNums + size * 7;
        if (n%7 != 0) {
            for (int i = 1; i <= (n%7); i++) {
                ans += weekNums + i;
            }
        }
        return ans;

    }
}
