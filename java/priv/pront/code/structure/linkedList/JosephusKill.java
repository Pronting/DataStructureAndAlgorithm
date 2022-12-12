package priv.pront.code.structure.linkedList;

/**
 * @Description: 约瑟夫环
 * @Author: pront
 * @Time:2022-12-10 12:07
 */
public class JosephusKill {

    public class Node {
        public Node next;
        public Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }

    private static Node josephusKill1(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        Node last = head;
        int count = 0;
        while (last.next != head) {
            last = last.next;
        }
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }


    public Node josephusKills2(Node head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        Node cur = head.next;
        int tmp = 1; //tmp ->list size
        while (cur != head) {
            tmp++;
            cur = cur.next;
        }
        tmp = getLive(tmp, m);   //tmp ->service node position
        while (--tmp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    private int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }
}
