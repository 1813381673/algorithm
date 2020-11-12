package simple;


import java.util.ArrayList;
import java.util.List;

/*
 *@author xsj
 *@Date 2020/11/12 21:12
 *NO.922
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 按奇偶排序数组II {
    public static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            // 如果偶数下标是奇数
            if (A[i] % 2 == 1) {
                // 奇数指针一直向前寻找，寻找第一个奇数下标   为偶数的数
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                // 然后交换两个数   偶数指针继续向后移动
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
