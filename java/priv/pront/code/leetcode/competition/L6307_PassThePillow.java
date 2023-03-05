package priv.pront.code.leetcode.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-05 10:32
 */
public class L6307_PassThePillow {


    public int pillowFight(int n, int time) {
        int pos = 0; // 初始位置为 0，表示队首
        int direction = 1; // 初始方向为 1，表示向右传递

        for (int i = 0; i < time; i++) {
            if (pos == n - 1) { // 到达队尾
                direction = -1; // 改变传递方向
            } else if (pos == 0) { // 到达队首
                direction = 1; // 改变传递方向
            }
            pos += direction; // 更新位置
        }

        return pos + 1; // 返回编号，需要加 1
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int time = scanner.nextInt();
        int index = time % (n - 1);
        if(n > time){
            System.out.println(index + 1);
            return;
        }
        if(time == n){
            System.out.println(1);
            return;
        }
        if(index == 0){
            System.out.println(n);
        }else{
            System.out.println(index + 1);
        }
    }
}
