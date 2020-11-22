package simple;


import java.util.HashMap;
import java.util.Map;

/**
 * @author xsj
 * @Date 2020/11/22 18:54
 * No.242
 *
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有效的字母异位词 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (int i = 0; i < len1; ++i) {
            char c = s.charAt(i);
            if (map1.containsKey(c)){
                map1.put(c, map1.get(c)+1);
            } else {
                map1.put(c, 1);
            }
            char c2 = t.charAt(i);
            if (map2.containsKey(c2)){
                map2.put(c2, map2.get(c2)+1);
            } else {
                map2.put(c2, 1);
            }
        }
        if (map1.size() != map2.size()) return false;
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2IsHave(map2, entry)) return false;
        }
        return true;


    }


    public static boolean map2IsHave(Map<Character,Integer> map, Map.Entry<Character,Integer> en){
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() == en.getKey() && entry.getValue().equals(en.getValue())){
                return true;
            }
        }
        return false;
    }
}
