package priv.pront.code.structure.linkedList;

import priv.pront.constants.LinkedListUtils;

import java.util.HashSet;

/**
 * @Description: 给定两个可能有环也可能无环的单链表，头节点head1,和head2.如果两个链表相交，返回相交的第一个节点，不相交返回null
 * @Author: pront
 * @Time:2022-08-12 16:40
 */
public class FindFirstIntersectNode {

//  1、  借助HashSet结构，每遍历一个节点放入set中，遍历完后，重复的set值就是第一个相交节点
    public static LinkedListUtils.Node getLoopNodeHashSet(LinkedListUtils.Node head1, LinkedListUtils.Node head2) {
        if ((head1 == null || head1.next == null) && (head2 == null || head2.next == null)) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        LinkedListUtils.Node cur1 = head1;
        while (cur1 != null) {
            set.add(cur1.value);
            cur1 = cur1.next;
        }

        LinkedListUtils.Node cur2 = head2;
        while (cur2 != null) {
            for (int value : set) {
                if (value == cur2.value) {
                    return cur2;
                }
            }
            cur2 = cur2.next;
        }
        return null;
    }

    //    2、f/s ，f走两步，s,走一步，相遇之后f回到起点，s原地不动 f/s一次一步，下一次相遇既是第一个相交节点
    public static LinkedListUtils.Node getLoopNode(LinkedListUtils.Node head) {
        //        least three
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        LinkedListUtils.Node n1 = head.next;  //    n1->slow
        LinkedListUtils.Node n2 = head.next.next;  //   n2->fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //   n2->walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
//        n1 or n2
        return n1;
    }

    public static LinkedListUtils.Node noLoop(LinkedListUtils.Node head1, LinkedListUtils.Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        LinkedListUtils.Node cur1 = head1;
        LinkedListUtils.Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
            cur1 = n > 0 ? head1 : head2; //谁长,谁的头变成cur1
            cur2 = cur1 == head1 ? head2 : head1; //谁短，谁的头变成cur2
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

        return cur1;
    }
    public static LinkedListUtils.Node bothLoop(LinkedListUtils.Node head1, LinkedListUtils.Node head2, LinkedListUtils.Node loop1, LinkedListUtils.Node loop2) {
        LinkedListUtils.Node cur1 = null;
        LinkedListUtils.Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static LinkedListUtils.Node getIntersectNode(LinkedListUtils.Node head1, LinkedListUtils.Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        LinkedListUtils.Node loop1 = getLoopNode(head1);
        LinkedListUtils.Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }

    public static void main(String[]args){
        LinkedListUtils.Node head1 = new LinkedListUtils.Node(2);
        LinkedListUtils.Node head2 = new LinkedListUtils.Node(2);
        head1.next = new LinkedListUtils.Node(3);
        head1.next.next = new LinkedListUtils.Node(5);
        head1.next.next.next = new LinkedListUtils.Node(8);
        head1.next.next.next.next = new LinkedListUtils.Node(9);
        head1.next.next.next.next.next = new LinkedListUtils.Node(7);
        head2.next = head1.next.next.next;

        getIntersectNode(head1, head2);

    }

}

