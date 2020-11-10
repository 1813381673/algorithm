package simple;

import java.util.ArrayList;
import java.util.List;

/*
 *来源LeetCode
 * NO.1431
 */
public class 拥有最多糖果的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList();
        int max = candies[0];
        //找到目前持有最多的糖果数
        for (int candy : candies) {
            if(candy>max) max=candy;
        }
        //如果糖果数加上新发的大于原来最多的就返回true
        for (int candy : candies) {
            if(candy+extraCandies>=max){
                result.add(true);
            }else {
                result.add(false);
            }
        }
        return result;
    }
}
