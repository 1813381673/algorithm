package simple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xsj
 * @Date 2020/12/6 10:08
 * No.118
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList(numRows);
        if (numRows == 1){
            ans.add(Arrays.asList(1));
            return ans;
        }
        if (numRows == 2){
            ans.add(Arrays.asList(1));
            ans.add(Arrays.asList(1,1));
            return ans;
        }
        ans.add(Arrays.asList(1));
        ans.add(Arrays.asList(1,1));
        int index = 2;
        while (index < numRows){
            List<Integer> list = new ArrayList(index+1);
            for (int i = 0; i < index+1; i++) {
                if (i == 0 || i == index){
                    list.add(1);
                } else {
                    list.add(ans.get(index-1).get(i-1)+ans.get(index-1).get(i));
                }
            }
            ans.add(list);
            index++;
        }
        return ans;
    }
}
