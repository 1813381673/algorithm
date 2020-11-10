package difficult;


/*
 *@author TT
 *@Date 2020/11/2 17:59
 *1074
 *
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。

子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。

如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同

* 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
输出：4
解释：四个只含 0 的 1x1 子矩阵。
*
* 输入：matrix = [[1,-1],[-1,1]], target = 0
输出：5
解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 元素和为目标值的子矩阵数量 {
    //转换为一个矩阵（长方形）求和为target的问题
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        for (int i = 0; i < matrix.length; ++i) {//长方形的上边
            for (int j = i; j < matrix.length; ++j) {//长方形的下边
                int[] sum = getSumOfLines(matrix,i,j);//获取到该长方形每一列的和  组成一个数组

                for (int k = 0; k < sum.length; ++k) {//左边开始的列

                    for (int l = k; l < sum.length; ++l) {//右边结束的列
                        int tempsum = 0;
                        for (int m = k; m <= l; ++m) {
                            tempsum += sum[m];
                        }
                        if(tempsum==target) {
                            //System.out.println("上边:"+i+",下边:"+j+",左边:"+k+",右边"+l);
                            ++ans;
                        }
                    }
                }

            }
        }
        return ans;
    }

    public static int[] getSumOfLines(int[][] matrix,int startLine,int endLine){
        int[] result = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            int sum = 0;
            for (int j = startLine; j <=endLine ; j++) {
                sum+= matrix[j][i];
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,-1},
                {-1,1}
        };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix,target));
    }
}
