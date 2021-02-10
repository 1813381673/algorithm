package middle;


import java.util.Arrays;

/**
 * @author TT
 * @Date 2021/2/10 9:19
 * No.567
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字符串的排列 {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] chars1 = new int[26];
        int left = 0;
        for (int i = 0; i < len1; i++) {
            ++chars1[s1.charAt(i) - 'a'];
        }
        int[] chars2 = new int[26];
        for (int i = 0; i < len1; i++) {
            ++chars2[s2.charAt(i) - 'a'];
        }
        for (int i = len1; i < len2; i++) {
            if (isSame(chars1, chars2)) return true;
            --chars2[s2.charAt(left++) - 'a'];
            ++chars2[s2.charAt(i) - 'a'];
        }
        return false;
    }

    public boolean isSame(int[] a, int[] b){
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        int a = 'a';
        int z = 'z';
        int size = 'z' - 'a';
        System.out.println(a);
        System.out.println(z);
        System.out.println(size);
    }
}
