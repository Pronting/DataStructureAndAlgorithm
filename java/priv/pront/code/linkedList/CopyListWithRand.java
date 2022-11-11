package priv.pront.code.linkedList;

import java.util.HashMap;
//O(N) O(1)
public class CopyListWithRand {
    public static Node copyListWithRand1(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
//            put
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
//            map.get(cur) new,cur old
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;

        while (cur != null) {
            next = cur.next;
//            当前节点的下一个放当前节点的克隆节点
            cur.next = new Node(cur.value);
//            克隆节点的下一个是老节点的下一个
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        Node curCopy = null;

//        拷贝rand
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }

        Node res = head.next;
        cur = head;

//        拆分
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static boolean equals(Node head, Node node) {
        boolean flag = false;
        while (head != null && node != null) {
            flag = head.next == node.next && head.rand == node.rand;
            head = head.next;
            node = node.next;
        }
        return flag;
    }

    //    for test
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next.next = new Node(6);
        head.rand = head.next.next;
        head.next.rand = head.next.next.next;
        head.next.next.next.rand = head.next.next.next.next.next.next.next.next;
//        Node node = copyListWithRand1(head);
        Node node = copyListWithRand2(head);
//       equals
        System.out.println(equals(head, node));


    }

    public static class Node {
        private final int value;
        //        next and rand pointer
        private Node next;
        private Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
}
