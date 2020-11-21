package simple;


/**
 * @author xsj
 * @Date 2020/11/21 10:38
 *
 * 剑指 Offer 05.
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        if (s == null || "".equals(s)) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
