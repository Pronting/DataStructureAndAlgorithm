package priv.pront.code.lanqiao.LG.P;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-11 16:52
 */

public class Main {
    static int[] parent;  // parent[i]表示第i个元素所在的集合

    // 初始化并查集
    static void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;  // -1表示第i个元素还没有被加入到集合中
        }
    }

    // 查找元素p所在的集合编号
    static int find(int p) {
        while (parent[p] >= 0) {  // 查找父节点，直到根节点
            p = parent[p];
        }
        return p;
    }

    // 将元素p和元素q所在的集合合并
    static void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            parent[pRoot] = qRoot;  // 将元素p所在的集合合并到元素q所在的集合
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 共有n个元素
        int m = scanner.nextInt();  // 共有m个操作

        // 初始化并查集
        init(n);

        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (op == 1) {  // 合并操作
                union(p, q);
            } else if (op == 2) {  // 查询操作
                int pRoot = find(p);
                int qRoot = find(q);
                if (pRoot == qRoot) {  // 如果p和q在同一个集合中
                    System.out.println('Y');  // 输出Y
                } else {
                    System.out.println('N');  // 否则输出N
                }
            }
        }
    }
}
