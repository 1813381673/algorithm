package simple;


import java.util.*;

/*
 *@author xsj
 *@Date 2020/11/14 11:01
 *No.1122
 *
 * 给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 

示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-sort-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 数组的相对排序 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) return  null;
        if (arr2 == null || arr2.length == 0){
            Arrays.sort(arr1);
            return arr1;
        }
        List<Integer> list = new ArrayList(arr1.length);
        Map<Integer,Integer> map = new HashMap(arr2.length);
        for (int i : arr1) {
            list.add(i);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],i);
        }
        //自定义排序规则
        Collections.sort(list,((o1, o2) -> {
            if (map.containsKey(o1) || map.containsKey(o2)){
                return map.getOrDefault(o1,1001) - map.getOrDefault(o2,1001);
            }
            return o1 - o2;
        }));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }


}
