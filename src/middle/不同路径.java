package middle;


import java.util.Arrays;

/**
 * @author xsj
 * @Date 2020/12/9 9:32
 *
 * No.62
 */
public class 不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] ans = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            ans[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            ans[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                ans[i][j] = ans[i-1][j] + ans[i][j-1];

            }
        }
        return ans[m][n];
    }
}
