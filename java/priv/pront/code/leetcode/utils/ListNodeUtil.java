package priv.pront.code.leetcode.utils;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-15 11:46
 */
public class ListNodeUtil {

    public static void printNodeValue(ListNode head){
        if(head == null){
            return;
        }
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static  ListNode getTestListNode(int[] listNodeValueArr){
        ListNode root = new ListNode(listNodeValueArr[0]);
        ListNode pre = root;
        for(int i = 1; i < listNodeValueArr.length; i++){
            pre.next = new ListNode(listNodeValueArr[i]);
            pre = pre.next;
        }
        return root;
    }
}
