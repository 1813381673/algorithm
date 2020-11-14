package middle;


import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/*
 *@author xsj
 *@Date 2020/11/13 16:13
 *No.39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
提示：

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

 */
public class 组合总和 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        int len = candidates.length;
        dfs(candidates, 0, len, target, path, ans);
        return ans;
    }

    public static void dfs(int[] candidates, int start, int end, int target, Deque<Integer> path,List<List<Integer>> ans){
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < end; i++) {
            if (target-candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            dfs(candidates,i,end,target-candidates[i],path,ans);
            path.removeLast();
        }
    }
}
