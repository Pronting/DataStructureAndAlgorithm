package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 16:57
 */
public class L142_GetLoopLinkedListNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null ||head.next == null || head.next.next == null){
            return null;
        }
        ListNode fastPointer = head.next.next;
        ListNode slowPointer = head.next;
        while(fastPointer != slowPointer){
            if(fastPointer.next == null||fastPointer.next.next == null){
                return null;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        fastPointer = head;

        while(fastPointer != slowPointer){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return fastPointer;

    }
}
