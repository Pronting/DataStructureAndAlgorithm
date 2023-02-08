package priv.pront.code.lanqiao.LG.P.bt;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 18:59
 */
public class P1705_PerTraverse_ans {

    int n = 0;
    char[][] a = new char[30][3];
    String s = new String();

    public static void main(String[] args) {
        new P1705_PerTraverse_ans().sf();
    }

    public void sf() {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            s = in.next().trim();
            for (int j = 0; j < 3; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        f(a[0][0]);
    }

    public void f(char x) {
        if (x != '*') {
            System.out.print(x);
            for (int i = 0; i < n; i++) {
                if (a[i][0] == x) {
                    f(a[i][1]);
                    f(a[i][2]);
                }
            }
        }

    }

}
