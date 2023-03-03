package priv.pront.code.lanqiao.teach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-02 11:17
 */
public class YueSeFu {

//    O(N * M)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNum = scanner.nextInt();
        int cycleNum = scanner.nextInt();
        System.out.println(yuesefu(totalNum, cycleNum));
        scanner.close();
    }

    public static int yuesefu(int totalNum, int countNum) {
        // 初始化人数
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        // 从第K个开始计数
        int k = 0;
        while (start.size() > 1) {
            k = k + countNum;
            // 第m人的索引位置
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            if (k < 0) {
                start.remove(start.size() - 1);
                k = 0;
            } else {
                start.remove(k);
            }
        }
        return start.get(0);
    }


    public static int yuesefu2(int n, int m){
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans + 1;
    }
}



