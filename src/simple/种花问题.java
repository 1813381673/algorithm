package simple;


import java.util.Arrays;

/**
 * @author TT
 * @Date 2021/1/1 9:06
 * No.605
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 种花问题 {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{0,0,1,0,0};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;
        if (flowerbed.length == 1) return flowerbed[0] == 1 ? n==0 : n<=1;
        // 这个花坛可以放多少朵花
        int count = 0;
        int len = flowerbed.length;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            ++count;
            flowerbed[0] = 1;
        }
        int index = 1;
        while (index < len) {
            if (flowerbed[index] == 0) {
                if (flowerbed[index-1] == 0) {
                    if (index+1 < len) {
                        if (flowerbed[index+1] == 0) {
                            flowerbed[index] = 1;
                            ++count;
                        }
                    } else {
                        flowerbed[index] = 1;
                        ++count;
                    }
                }
            }
            ++ index;
        }
        System.out.println(Arrays.toString(flowerbed));
        return n <= count;

    }

}
