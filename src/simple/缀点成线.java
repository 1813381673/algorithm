package simple;


/**
 * @author TT
 * @Date 2021/1/17 10:31
 * No.1232
 *
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 *
 */
public class 缀点成线 {
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int x2 = coordinates[1][0], x1 = coordinates[0][0];
        int y2 = coordinates[1][1], y1 = coordinates[0][1];
        for (int i = 2; i <len ; i++) {
            if ((x2-x1) * (coordinates[i][1] - y2) != (coordinates[i][0] - x2) * (y2-y1 ) ){
                return false;
            }
        }
        return true;

    }

}
