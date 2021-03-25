package middle;


/**
 * @author TT
 * @Date 2021/3/25 8:28
 * No.82
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除排序链表中的重复元素II {

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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode pre = new ListNode(-1);
            ListNode tempHead = pre;
            while (head != null && head.next != null) {
                System.out.println("ces" + head.val);
                if (head.val == head.next.val) {
                    int value = head.val;
                    while (head != null && head.val == value) {
                        tempHead.next = head.next;
                        head = head.next;
                    }
                } else {
                    tempHead.next = head;
                    tempHead = tempHead.next;
                    head = head.next;
                }

            }
            if(head != null) {
                tempHead.next = head;
            }
            return pre.next;
        }
    }
}
