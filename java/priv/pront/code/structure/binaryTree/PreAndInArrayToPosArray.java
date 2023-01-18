package priv.pront.code.structure.binaryTree;

import java.util.HashMap;

/**
 * @Description: 已知一棵二叉树中没有重复节点，且给定了这棵树的中序遍历数组和先序遍历数组，返回后序遍历数组
 * @Author: pront
 * @Time:2023-01-15 15:49
 */
public class PreAndInArrayToPosArray {
    public static int[] getPosArray(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        int len = pre.length;
        int[] pos = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        setPos(pre, 0, len - 1, in, 0, len - 1, pos, len - 1, map);
        return pos;
    }

    public static int setPos(int[] p, int pi, int pj, int[] n, int ni, int nj, int[] s, int si,
                             HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return si;
        }
        s[si--] = p[pi];
        int i = map.get(p[pi]);
        si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, s, si, map);
        return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, s, si, map);
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void setPos2(int[] pre, int[] in, int[] pos, int prei, int prej, int ini, int inj, int posi, int posj) {
        if (prei > prej) {
            return;
        }
        if (prei == prej) {
            pos[posi] = pre[prei];
            return;
        }
        pos[posj] = pre[prei];
        int find = ini;
        for (; find <= ini; find++) {
            if (in[find] == pre[prei]) {
                break;
            }
        }
        setPos2(pre, in, pos, prei + 1, prei + find - ini, ini, find - 1, posi, posi + find - ini);
        setPos2(pre, in, pos, prei + find - ini + 1, prej, find + 1, inj, posi + find - ini + 1, posj - 1);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pos = getPosArray(pre, in);
        printArray(pos);

    }
}
