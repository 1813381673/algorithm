package middle;


/**
 * @author TT
 * @Date 2021/1/3 16:01
 *
 * No.86
 *
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分割链表 {

    public ListNode partition(ListNode head, int x) {
        // 第一个链表保存比值小的
        ListNode pre = new ListNode(-1);
        ListNode preHead = pre;
        // 第二个链表保存其余的
        ListNode after = new ListNode(-1);
        ListNode afterHead = after;
        while (head != null) {
            if (head.val < x) {
                preHead.next = head;
                preHead = preHead.next;
            } else {
                afterHead.next = head;
                afterHead = afterHead.next;
            }
            head = head.next;
        }
        // 见两个链表 链接起来  并在末尾置null
        afterHead.next = null;
        preHead.next = after.next;
        return pre.next;

    }
}
