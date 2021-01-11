package middle;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author TT
 * @Date 2021/1/11 12:57
 * No.1202
 *
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 交换字符串中的元素 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        int len = s.length();
        DisjoinSet disjoinSet = new DisjoinSet(len);
        // 放入并查集
        for (List<Integer> pair : pairs) {
            disjoinSet.union(pair.get(0), pair.get(1));
        }
        // 映射
        Map<Integer, PriorityQueue<Character>> map = new HashMap(len);
        for (int i = 0; i < len; i++) {
            int root = disjoinSet.findRoot(i);
            if (map.containsKey(root)) {
                map.get(root).offer(s.charAt(i));
            } else {
                PriorityQueue<Character> minHeap = new PriorityQueue();
                minHeap.offer(s.charAt(i));
                map.put(root, minHeap);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = disjoinSet.findRoot(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }

    class DisjoinSet {
        private int[] parent;
        private int[] rank;

        public DisjoinSet(int size){
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = -1;
            }
        }
        // 找一个节点的根节点
        public int findRoot(int x){
            int temp = x;
            while (this.parent[x] != -1) {
                x = this.parent[x];
                ++this.rank[temp];
            }
            return x;
        }
        // 合并
        public void union(int x, int y){
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);
            if (xRoot == yRoot) return;
            if (this.rank[x] > this.rank[y]) {
                this.parent[yRoot] = xRoot;
            } else {
                this.parent[xRoot] = yRoot;
            }
        }
    }
}
