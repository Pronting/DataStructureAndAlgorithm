package priv.pront.code.leetcode.linkedList;

import priv.pront.code.leetcode.utils.ListNode;
import priv.pront.code.leetcode.utils.ListNodeUtil;

import java.util.List;

public class L19_RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.getTestListNode(new int[]{1, 2});
        ListNode listNode = removeNthFromEnd(head, 2);
        System.out.println(listNode.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int size = 0;
        while(p != null){
            p = p.next;
            size ++;
        }

        n = size - n + 1;
        p = head;
        if(n == 1) return head.next;
        while(--n > 1){
            p = p.next;
        }
        ListNode p2 = p.next;
        p.next = p2.next;
        p2.next = null;

        return head;

    }
}
