package simple;


/**
 * @author xsj
 * @Date 2020/12/6 10:39
 * No.5617
 *
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *
 *
 * 提示：
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class 设计Goal解析器 {

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        int index = 0;
        while (index < len){
            if (command.charAt(index) == 'G'){
                sb.append('G');
                index++;
            } else {
                if (command.charAt(index+1) == ')'){
                    sb.append('o');
                    index += 2;
                } else {
                    sb.append("al");
                    index += 4;
                }
            }
        }
        return sb.toString();
    }
}
