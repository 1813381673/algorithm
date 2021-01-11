package disjoinSet;


/**
 * @author TT
 * @Date 2021/1/11 12:19
 * @Description 并查集  最直观的就是可以检测无向图有没有环
 */
public class Demo1 {

    private int[] parent;
    private int[] ranks; // 描述深度

    public Demo1(int[] parent) {
        this.parent = parent;
        this.ranks = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = -1;
        }
    }
    // 找根节点
    public int findRoot(int x){
        int temp = x;
        while (parent[x] != -1) {
            x = parent[x];
            ++ranks[temp]; // 深度+1
        }
        return x;
    }
    // 合并两个集合  返回是否能够成功合并
    public boolean unionVertices(int x, int y){
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);
        if (xRoot != yRoot) {
            //parent[xRoot] = yRoot; // 可能会产生很长的路径
            // 压缩路径
            if (ranks[x] > ranks[y]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
            }

        }
        return xRoot != yRoot;
    }

    public static void main(String[] args) {
        // 初始化图   描述边的信息
        int vertices = 6; // 顶点个数
        // 描述哪两个点连接  顶点标号从0开始
        int[][] edges = {
                {0,1},
                {1,2},
                {1,3},
                {2,4},
                {3,4},
                {2,5}
        };
        int[] parent = new int[vertices];
        Demo1 demo1 = new Demo1(parent);
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (!demo1.unionVertices(x, y)) {
                System.out.println("合并失败 有环");
                return;
            }
        }
        System.out.println("合并成功  无环");
    }


}
