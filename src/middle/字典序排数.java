package middle;


import java.util.ArrayList;
import java.util.List;

/*
 *@author xsj
 *@Date 2020/11/10 17:44
 *NO.386
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。

例如，

给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。

请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lexicographical-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字典序排数 {
    //dfs  先序遍历  类似二叉搜索树
    public static List<Integer> lexicalOrder(int n) {
        if (n <= 0) return null;
        List<Integer> ans = new ArrayList<>(n);
        for (int i = 1; i < 10; ++i) {//树的根节点为0  其下的孩子有 1 2 3 4 5 6 7 8 9 我们从这一层开始遍历  深度优先逐层遍历  如果i>n就返回
            dfs(n,i,ans);
        }
        return ans;
    }

    public static void dfs(int n,int i,List<Integer> list){
        if (i>n) return;
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            dfs(n,i*10+j,list);
        }
    }
}
