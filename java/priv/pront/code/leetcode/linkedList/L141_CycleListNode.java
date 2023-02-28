package priv.pront.code.leetcode.linkedList;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-28 14:36
 */
public class L141_CycleListNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        head.next = second;
        second.next = new ListNode(0);
        second.next.next = new ListNode(-4);
        second.next.next.next = second;

        System.out.println(hasCycle(head));
    }
}
