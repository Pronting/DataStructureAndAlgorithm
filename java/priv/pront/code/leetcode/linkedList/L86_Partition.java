package priv.pront.code.leetcode.linkedList;

import priv.pront.code.leetcode.utils.ListNode;
import priv.pront.code.leetcode.utils.ListNodeUtil;

public class L86_Partition {

    public static ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode(0);
        ListNode bigDummp = big;
        ListNode small = new ListNode(0);
        ListNode smallDummp = small;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x) {
                smallDummp.next = cur;
                smallDummp = smallDummp.next;
            } else{
                bigDummp.next = cur;
                bigDummp = bigDummp.next;
            }
            cur = cur.next;
        }
        bigDummp.next = null;
        smallDummp.next = big.next;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode testListNode = ListNodeUtil.getTestListNode(new int[]{1, 4, 3, 2, 5, 2});
        partition(testListNode, 3);
    }
}
