package simple;


import java.util.ArrayList;
import java.util.List;

/*
 *@author xsj
 *@Date 2020/11/15 11:01
 *
 * No.5601
 *
 * 
 */
public class 设计有序流 {
    private Integer n;
    private String[] num;
    private Integer ptr;
    public 设计有序流(int n) {
        this.n = n;
        this.num = new String[n+1];
        this.ptr = 1;
    }

    public List<String> insert(int id, String value) {
        List<String> ans = new ArrayList();
        num[id] = value;
        if (id == ptr){
            for (int i = ptr; i <= n; i++) {
                if (num[i] != null){
                    ans.add(num[i]);
                    ptr = i+1;
                } else {
                    break;
                }
            }
        }
        return ans;
    }


}
