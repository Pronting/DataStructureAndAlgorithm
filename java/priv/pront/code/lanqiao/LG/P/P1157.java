package priv.pront.code.lanqiao.LG.P;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 20:42
 */
public class P1157 {


        public static void main(String[] args) {
            P1157 m = new P1157();
            m.handleInput();
        }

        int n = 0, r = 0;
        int[] a = new int[250];

        public void handleInput() {
            Scanner in = new Scanner(System.in);

            if (in.hasNext()) {
                n = in.nextInt();
                r = in.nextInt();
            }
            dfs(1);

        }

        public void dfs(int step) {

            if (step > r) {
                for (int i = 1; i <= r; i++) {
                    System.out.printf("%3d", a[i]);
                }
                System.out.println();
                return;
            }
            for (int i = a[step - 1] + 1; i <= n; i++) {
                a[step] = i;
                dfs(step + 1);
            }
        }
    }
