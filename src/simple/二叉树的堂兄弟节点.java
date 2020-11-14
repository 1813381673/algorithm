package simple;


import java.util.HashMap;
import java.util.Map;

/*
 *@author xsj
 *@Date 2020/11/13 16:49
 *No.993
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
提示：

二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class 二叉树的堂兄弟节点 {
    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depth = new HashMap();
        Map<Integer, TreeNode> parent = new HashMap();
        dfs(root, null,depth,parent);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public static void dfs(TreeNode node, TreeNode par,Map<Integer,Integer> depth,Map<Integer,TreeNode> parent) {
        if (node != null) {
            if (par != null){
                depth.put(node.val, 1 + depth.get(par.val));
            } else {
                depth.put(node.val, 0);
            }
            parent.put(node.val, par);
            dfs(node.left, node, depth, parent);
            dfs(node.right, node, depth, parent);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
