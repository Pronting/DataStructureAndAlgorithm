package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 15:10
 */
public class L206_ReverseLinkedList {

    public static class ListNode{
        ListNode next;
        public int value;

        public ListNode(int value){
            this.value = value;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = null;
        while(head != null){
            fast = head.next;
            head.next = slow;
            slow = head;
            head = fast;
        }
        return slow;

    }
    public static void printNode(ListNode head){
        while(head != null){
            System.out.print(head.value +" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseList(head);
        printNode(listNode);
    }
}
