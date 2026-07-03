package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E2024_路灯照明 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> intervals = new ArrayList<>();
        int end = (n - 1) * 100;  // 最后一个路灯的位置

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int left = Math.max(0, i * 100 - r);
            int right = Math.min(end, i * 100 + r);
            intervals.add(new int[]{left, right});
        }

        // 按左端点排序
        intervals.sort((a, b) -> a[0] - b[0]);

        int ans = 0;
        int curL = intervals.get(0)[0];
        int curR = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int[] seg = intervals.get(i);
            if (seg[0] <= curR) {
                // 有重叠或相邻，合并
                curR = Math.max(curR, seg[1]);
            } else {
                // 出现空隙，累加
                ans += seg[0] - curR;
                curL = seg[0];
                curR = seg[1];
            }
        }

        System.out.println(ans);
    }
}
