package middle;


import java.util.*;

/*
 *@author xsj
 *@Date 2020/11/16 18:41
 *
 * No.406
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 官方答案 插空法
public class 根据身高创建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) return people;
        int len = people.length;
        //排序按照身高降序  k升序
        Arrays.sort(people,((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        }));
        List<int[]> ans = new ArrayList();
        for (int[] person : people) {
            // 插空法
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);


    }

}
