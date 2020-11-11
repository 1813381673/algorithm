package middle;


import java.util.HashMap;
import java.util.Map;

/*
 *@author xsj
 *@Date 2020/11/10 19:20
 *NO.447
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:
输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-boomerangs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 回旋镖的数量 {
    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 2) return 0;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map = new HashMap();//计算每个点的距离 如果存在相同距离就计数+1  如果计数>1说明可以构成回旋镖
            for (int j = 0; j < points.length; j++) {
                if (i != j){
                    int distance = (int) (Math.pow(points[i][0]-points[j][0],2) + Math.pow(points[i][1]-points[j][1],2));
                    if (!map.containsKey(distance)){
                        map.put(distance,1);
                    } else{
                        map.put(distance,map.get(distance)+1);
                    }
                }
            }
            System.out.println(map);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                if (num>1) ans += num*(num-1);//构成回旋镖的数目为 计数值*(计数-1)
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a = {
                {0,0},
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}

        };
        System.out.println(numberOfBoomerangs(a));
    }
}
