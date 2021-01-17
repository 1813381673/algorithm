package simple;


import java.util.HashMap;
import java.util.Map;

/**
 * @author TT
 * @Date 2021/1/17 10:44
 * No.5653
 *
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 *
 * 返回可以切出边长为 maxLen 的正方形的矩形 数目 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * 输出：3
 * 解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 * 最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 * 示例 2：
 *
 * 输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= rectangles.length <= 1000
 * rectangles[i].length == 2
 * 1 <= li, wi <= 109
 * li != wi
 *
 */
public class 可以形成最大正方形的矩形数目 {

    public static void main(String[] args) {
        int[][] rectangles = {
                {5,8},
                {3,9},
                {5,12},
                {166,5},
        };
        System.out.println(countGoodRectangles(rectangles));
        System.out.println("测试");
    }

    public static int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap();
        int max = -1;
        int len = rectangles.length;
        for (int i = 0; i < len; i++) {
            int maxLen = Math.min(rectangles[i][0],rectangles[i][1]);
            if (maxLen >= max) {
                max = maxLen;
                map.put(maxLen, map.getOrDefault(maxLen,0) + 1);
            }
        }
        return map.get(max);
    }
}
