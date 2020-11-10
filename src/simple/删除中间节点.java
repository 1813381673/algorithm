package simple;


/*
 *@author TT
 *@Date 2020/10/30 16:33
 *
 * 来源 LeetCode
 */
//实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//存在问题：   这个节点的”下一个节点“被顶替了  那么这个“下一个节点”的next一直存在引用  除非是null
public class 删除中间节点 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }
}