package priv.pront.code.leetcode.linkedList;

import priv.pront.code.leetcode.utils.ListNode;

public class L24_SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode end = cur.next.next;
            cur.next.next = end.next;
            end.next = cur.next;
            cur.next = end;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
