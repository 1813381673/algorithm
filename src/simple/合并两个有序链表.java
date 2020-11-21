package simple;


/**
 * @author xsj
 * @Date 2020/11/21 9:52
 *
 * No.21
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(0);
        ListNode temp = tempHead;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null){
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null){
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return tempHead.next;


    }
}
