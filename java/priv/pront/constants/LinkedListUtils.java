package priv.pront.constants;


/**
 * @Description: 链表工具类
 * @Author: pront
 * @Time:2022-08-12 16:07
 */
public class LinkedListUtils {

    public static Node getAppointNode(int nodeSize,int min,int max) {
        Node head = new Node((int) (Math.random() * max + min));
        Node node = head;
        for (int i = 2; i <=nodeSize ; i++) {
            head.next = new Node((int) (Math.random() * max + min));
            head = head.next;
        }
        return node;
    }


    public static class Node {
        public final int value;
        //        next and rand pointer
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }
}
