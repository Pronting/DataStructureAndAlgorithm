package priv.pront.code.lanqiao.LG.P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-14 12:39
 */
public class P2015_KQueen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        int k = input.nextInt();
        //map记录每行的列
        int[] map = new int[col + 1];
        int[] x = new int[k + 1];
        int[] y = new int[k + 1];
        for (int i = 1; i < k + 1; i++) {
            //记录输入坐标，y为纵坐标，x为横坐标
            y[i] = input.nextInt();
            x[i] = input.nextInt();
        }
        Arrays.fill(map, 0);
        //map全部初始化为0；
        int t = 0, sum = 0;
        //t统计每行里面不受攻击的格子数，sum统计总的不受攻击的格子数。
        for (int i = 1; i <= row; i++) {
            t = col;
            //每次循环都重新赋值为列的个数m,每一个格子受到攻击，则t--；
            for (int j = 1; j <= k; j++) {
                if (y[j] == i) {
                    //如果y[j]==i；即当前i行上面有皇后，整一行都被攻击，t=0；
                    t = 0;
                    break;
                }
                if (map[x[j]] != i) {
                    //这里的i和map[x[j]]没有什么特殊的联系，不管是第几行，同列的攻击。
                    // 只是我们把赋值为i后，下面用！=i作为判断，以便下面判断斜线的时候不会重复统计
                    map[x[j]] = i;
                    t--;
                }
                if ((i + x[j] - y[j]) > 0 && (i + x[j] - y[j]) <= col && map[i + x[j] - y[j]] != i) {
                    //判断正斜线（x1-y1)==(x2-y2) --> x2==y2+x1-y1==i + x[j] - y[j];
                    map[i + x[j] - y[j]] = i;
                    t--;
                }
                if ((x[j] + y[j] - i) > 0 && (x[j] + y[j] - i) <= col && map[x[j] + y[j] - i] != i) {
                    //判断反斜线 （x1+y1)=(x2+y2) --> x2==x1+y1-y2==x[j] + y[j] - i;
                    map[x[j] + y[j] - i] = i;
                    t--;
                }
            }
            sum += t;
        }
        System.out.println(sum);
    }
}
