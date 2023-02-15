package priv.pront.code.leetcode.linkedList;

import priv.pront.code.leetcode.utils.ListNode;
import priv.pront.code.leetcode.utils.ListNodeUtil;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 11:40
 */
public class L2_AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long sum1 = getSum(l1);
        long sum2 = getSum(l2);
        long ans = (sum1 + sum2);

        int digit = (ans + "").length();
        digit--;
        long value = ans / (long) Math.pow(10, digit--) % 10;
        ListNode root = new ListNode((int)value);
        ListNode pre = root;
        while (digit >= 0) {
            long val = ans / (long) Math.pow(10, digit--) % 10;
            pre.next = new ListNode((int)val);
            pre = pre.next;
        }
        return reverse(root);


    }

    public static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode fast = null;
        while (cur != null) {
            fast = cur.next;
            cur.next = pre;
            pre = cur;
            cur = fast;
        }
        return pre;
    }

    public static long getSum(ListNode head) {
        long sum = 0, index = 0;

        while (head != null) {
            sum += head.val * Math.pow(10, index++);
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode testListNode = ListNodeUtil.getTestListNode(new int[]{9});
        ListNode testListNode2 = ListNodeUtil.getTestListNode(new int[]{1, 9, 9, 9, 9, 9, 9, 9 ,9 ,9});
        ListNode listNode = addTwoNumbers(testListNode, testListNode2);
        ListNodeUtil.printNodeValue(listNode);


    }
}
