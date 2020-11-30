package middle;


import java.util.*;

/**
 * @author xsj
 * @Date 2020/11/30 8:23
 * No.767
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 重构字符串 {

    public static String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap();
        int len = S.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            max = Math.max(max,map.get(c));
        }
        int mid = (len+1)/2;
        if (max > mid) return ""; // 如果有元素的个数超过一半多 就不能构成答案
        List<Map.Entry<Character,Integer>> list = new ArrayList(map.entrySet()); // 对map假排序
        Collections.sort(list,((o1, o2) -> {
            return o2.getValue()>o1.getValue()?1:-1;
        }));
        System.out.println(list);
        char[] result = new char[len];
        int listL = list.size();
        int index = 0;
        for (int i = 0; i < listL; i++) { // 先插个数多的字符 并且优先插偶数下标 然后依次插空就行
            Character c = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            while (value != 0 && index<len){
                result[index] = c;
                index += 2;
                --value;
            }
            System.out.println("i="+i+"; value= "+value+"; index="+index);
            if (index%2 == 0 && index >= len) { // 如果偶数插满了  就换奇数插
                index = 1;
            }
            while (value != 0 && index<len){
                result[index] = c;
                index += 2;
                --value;
            }
        }
        System.out.println(Arrays.toString(result));
        return new String(result);


    }
}
