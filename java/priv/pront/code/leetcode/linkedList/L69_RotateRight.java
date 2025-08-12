package priv.pront.code.leetcode.linkedList;

import priv.pront.code.leetcode.utils.ListNode;
import priv.pront.code.leetcode.utils.ListNodeUtil;

public class L69_RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast  = dummy, slow = dummy;
        for(int i = 0; i <= k && fast != null; i++) fast = fast.next;
        while(fast!= null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow = slow.next;
        ListNode next = slow.next;
        slow.next = null;
        fast.next = head;
        return next;
    }

    public static void main(String[] args) {
        L69_RotateRight rotateRight = new L69_RotateRight();
        ListNode listNode = rotateRight.rotateRight(ListNodeUtil.getTestListNode(new int[]{1, 2, 3, 4, 5}), 2);
        ListNodeUtil.printNodeValue(listNode);

    }

}
