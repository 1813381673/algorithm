package middle;


/**
 * @author TT
 * @Date 2021/3/18 8:51
 * No.92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转链表II {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode newList = new ListNode(-1);
            ListNode ans = newList;
            for (int i = 0; i < left-1; i++) {
                newList.next = head;
                head = head.next;
            }
            System.out.println(ans.val + " \t" + ans.next.val);
            ListNode tempList = new ListNode(-1);
            ListNode startNode = head; // 反转开始的节点，也就是反转之后最后一个节点
            for (int i = left; i <= right; i++) {
                ListNode next = head.next;
                head.next = tempList.next;
                tempList.next = head;
                head = next;
            }
            newList.next = tempList.next;
            while (head != null) {
                startNode.next = head;
                head = head.next;
                startNode = startNode.next;
            }
            return ans.next;

        }
    }
}
