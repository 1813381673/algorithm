package simple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TT
 * @Date 2021/1/5 9:35
 * No.830
 *
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 *
 * 输入：s = "aba"
 * 输出：[]
 *  
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class 较大分组的位置 {

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList();
        int len = s.length();
        if (len < 3) return ans;
        int i = 0;
        while (i < len-2) {
            if (s.charAt(i) != s.charAt(i+2)) {
                ++i;
                continue;
            }
            char c = s.charAt(i);
            int num = 0;
            int startIndex = i;
            while (i < len && s.charAt(i) == c) {
                ++i;
                ++num;
            }
            if (num >= 3){
                ans.add(Arrays.asList(startIndex,i-1));
            } else {
                i = startIndex+2;
            }

        }
        return ans;
    }

}
