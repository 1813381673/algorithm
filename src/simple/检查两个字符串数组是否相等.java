package simple;


/**
 * @author xsj
 * @Date 2020/11/22 10:31
 * No.5605
 *
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 */
public class 检查两个字符串数组是否相等 {

    public static void main(String[] args) {
        String[] word1 = {
                "a",
                "bc"

        };
        String[] word2 = {
                "ab",
                "c"

        };
        System.out.println(arrayStringsAreEqual(word1,word2));

    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;
        int index1 = 0;
        int index2 = 0;
        int strlen2 = word2[index2].length();
        int tempIndex = 0;
        while (index1 < len1 && index2 < len2){
            int strlen1 = word1[index1].length();
            String s = word1[index1];
            for (int i = 0; i < strlen1; ++i) {
                char c1 = s.charAt(i);
                char c2 = getCharFromString2(word2, index2, tempIndex);
                if (c1 != c2){
                    //System.out.println("测试1");
                    return false;
                } else {
                    //System.out.println("-------------------");
                    //System.out.println("c1="+c1+",  c2="+c2+" ");
                    ++tempIndex;

                    // 如果这个元素遍历完了 换下一个
                    if (tempIndex >= strlen2){
                        ++index2;
                        tempIndex = 0;
                        //System.out.println(index2);
                        //System.out.println("-------------------");
                        // 如果第二个数组也遍历完了  那么判断第一个数组是否也遍历完了
                        if (index2>=len2 && ((i+1) < strlen1 || (index1+1) < len1)) {
                            //System.out.println("测试2");
                            return false;
                        } else if(index2 < len2){
                            strlen2 = word2[index2].length();
                        }
                    }
                }
            }
            ++index1;
        }
        // 判断两个数组是不是都遍历完了
        if (index1 == len1 && index2 == len2) {
            return true;
        } else {
            /*System.out.println(index1);
            System.out.println(index2);
            System.out.println("测试3");*/
            return false;
        }



    }

    public static char getCharFromString2(String[] word2, int index2, int i){
        return word2[index2].charAt(i);
    }


}
