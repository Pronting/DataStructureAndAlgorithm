package priv.pront.code.od;

import java.util.Scanner;

/**
 * 题目描述
 * 华为商城举办了一个促销活动，如果某顾客是某一秒内最早时刻下单的顾客（可能是多个人），则可以获取免单。
 *
 * 请你编程计算有多少顾客可以获取免单。
 *
 * 输入描述
 * 输入为 n 行数据，每一行表示一位顾客的下单时间
 *
 * 以（年-月-日时-分-秒.毫秒） yyyy-MM-ddHH:mm:ss.fff 形式给出。
 *
 * 0<n<50000
 * 2000<yyyy<2020
 * 0<MM<=12
 * 0<dd<=28
 * 0<=HH<=23
 * 0<=mm<=59
 * 0<=ss<=59
 * 0<=fff<=999
 * 所有输入保证合法。
 *
 * 输出描述
 * 输出一个整数，表示有多少顾客可以获取免单。
 */
public class E2024_免单统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String prevSecond = null;
        String minTime = null;
        int count = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine().trim();

            // 秒级 key（前19位：yyyy-MM-dd HH:mm:ss）
            String sec = s.substring(0, 19);
            if (!sec.equals(prevSecond)) {
                // 结算上一秒
                if (prevSecond != null) {
                    ans += count;
                }

                // 新秒初始化
                prevSecond = sec;
                minTime = s;
                count = 1;
            } else {
                // 同一秒比较毫秒
                if (s.compareTo(minTime) < 0) {
                    minTime = s;
                    count = 1;
                } else if (s.equals(minTime)) {
                    count++;
                }
            }
        }

        // 结算最后一组
        if (prevSecond != null) {
            ans += count;
        }

        System.out.println(ans);
    }
}
