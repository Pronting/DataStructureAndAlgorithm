package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-11 18:21
 */
public class P1030 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] in = scanner.next().toCharArray();
        char[] pos = scanner.next().toCharArray();
        char[] pre = new char[in.length];
        process(in, pos, pre, 0, in.length - 1, 0, pos.length - 1, 0, pre.length - 1);
        System.out.println(new String(pre));
    }

    public static void process(char[] in, char[] pos, char[] pre, int ini, int inj, int posi, int posj, int prei, int prej) {
        if (ini > inj || posi > posj) {
            return;
        }
        for (int i = ini; i <= inj; i++) {
            if (in[i] == pos[posj]) {
                ini = i;
                break;
            }
        }
        pre[prei] = pos[posj];
        int leftLen = ini - ini + 1;
        // 左子树
        process(in, pos, pre, ini - leftLen + 1, ini - 1, posi, posi + leftLen - 2, prei + 1, prei + leftLen - 1);
        // 右子树
        process(in, pos, pre, ini + 1, inj, posi + leftLen - 1, posj - 1, prei + leftLen, prej);
    }
}
