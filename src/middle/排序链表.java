package middle;


/**
 * @author xsj
 * @Date 2020/11/21 10:13
 *No.148
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 */
public class 排序链表 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }
    // 分
    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 快慢指针寻找中间节点
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode listNode1 = sortList(head, slow);
        ListNode listNode2 = sortList(slow, tail);
        ListNode ans = mergeListNode(listNode1, listNode2);
        return ans;
    }
    // 治
    public ListNode mergeListNode(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
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
        return pre.next;



    }


}
