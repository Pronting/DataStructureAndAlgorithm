package priv.pront.code.leetcode.algorithm.doublePointer;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-12 16:08
 */
public class L19_RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode root =  reverse(head);
        ListNode pre = root;
        ListNode pre2 = root;
        ListNode p1 = null;
        ListNode p2 = null;
        if(n == 1){
            ListNode preRoot = root.next;
            root.next = null;
            return reverse(preRoot);
        }

        for(int i = 1; i < n;i++){
            p1 = pre2.next;
            pre2 = pre2.next;
        }
        for(int i = 2; i< n;i++){
            pre = pre.next;
        }

        pre.next = p1.next;
        p1.next = null;
        return reverse(root);
    }

    public static ListNode reverse(ListNode head){
        ListNode slow = null;
        ListNode fast = null;
        ListNode p =  head;
        while(p != null){
            fast = p.next;
            p.next = slow;
            slow = p;
            p = fast;
        }
        return slow;
    }

    public static void printNode(ListNode head){
        while(head != null){
            System.out.print(head.val +" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode listNode = removeNthFromEnd(head, 7);
        printNode(listNode);
    }

}
