package priv.pront.code.lanqiao.LG.P.bt;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 18:24
 */
public class P1705_PreTraverse {

    public static String[] nodes = {"abc","bdj","dbi","cj*"};

    public static class Node {
        public char value;
        public Node left;
        public Node right;

        public Node(char value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        nodes = new String[n];
//        for (int i = 0; i < n; i++) {
//            nodes[i] = scanner.next();
//        }
        preTraverse();
    }

    private static void preTraverse() {
        Node root = new Node(nodes[0].charAt(0));
        for (String node : nodes) {
            char[] chars = node.toCharArray();
            for (int i = 0; i < 3; i++) {

//                部分相连完成
                Node partRoot = new Node(chars[0]);
                if (chars[1] != '*') {
                    partRoot.left = new Node(chars[1]);
                }
                if (chars[2] != '*') {
                    partRoot.right = new Node(chars[2]);
                }
            }
        }

        prePrint(root);
    }

    private static void prePrint(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.value);
        prePrint(root.left);
        prePrint(root.right);

    }


}
