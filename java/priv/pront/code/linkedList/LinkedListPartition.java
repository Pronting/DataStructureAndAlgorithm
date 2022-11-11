package priv.pront.code.linkedList;

public class LinkedListPartition {
    public static class Node {
        public int value;
        public Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listPartition(Node head, int pivot) {
        if (head == null || head.next == null) {
            return null;
        }
        Node SH = null, ST = null, EH = null, ET = null, MH = null, MT = null;
        Node next = null;

//        every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (SH == null) {
                    SH = head;
                    ST = head;
                } else {
                    ST.next = head;
                    ST = head;
                }
            } else if (head.value == pivot) {
                if (EH == null) {
                    EH = head;
                    ET = head;
                } else {
                    ET.next = head;
                    ET = head;
                }
            } else {
                if (MT == null) {
                    MH = head;
                    MT = head;
                } else {
                    MT.next = head;
                    MT = head;
                }
            }
            head = next;
        }
//        small and equal reconnect
//        if have not equal place
        if (ST != null) {
            //如果有小于区域
            ST.next = EH;
            ET = ET == null ? ST : ET; //谁去连接大于区域的头，谁就变成ET
        }

//        all reconnect
        if (ET != null) {
            ET.next = MH;
        }
        return SH != null ? SH : (EH != null ? EH : MH);
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
        Node node = listPartition(head, 0);
        System.out.println(node);
    }
}
