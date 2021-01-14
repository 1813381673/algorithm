package simple;


/**
 * @author TT
 * @Date 2021/1/13 16:15
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode tempHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = tempHead.next;
            tempHead.next = head;
            head = next;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode node = reverse2(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
