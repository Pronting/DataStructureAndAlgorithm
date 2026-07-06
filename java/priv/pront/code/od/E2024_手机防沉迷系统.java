package priv.pront.code.od;

import priv.pront.code.algorithm.sort.heap.A;

import java.util.*;

/**
 * 智能手机方便了我们生活的同时，也侵占了我们不少的时间。“手机App防沉迷系统”能够让我们每天合理地规划手机App使用时间，在正确的时间做正确的事。
 *
 * 它的大概原理是这样的：
 *
 * 在一天24小时内，可以注册每个App的允许使用时段
 * 一个时间段只能使用一个App
 * App有优先级，数值越高，优先级越高。注册使用时段时，如果高优先级的App时间和低优先级的时段有冲突，则系统会自动注销低优先级的时段，如果App的优先级相同，则后添加的App不能注册。
 * 请编程实现，根据输入数据注册App，并根据输入的时间点，返回时间点使用的App名称，如果该时间点没有注册任何App，请返回字符串“NA”。
 *
 * 输入描述
 * 第一行表示注册的App数量 N（N ≤ 100）
 *
 * 第二部分包括 N 行，每行表示一条App注册数据
 *
 * 最后一行输入一个时间点，程序即返回该时间点使用的App
 *
 * 2
 * App1 1 09:00 10:00
 * App2 2 11:00 11:30
 * 09:30
 *
 * 数据说明如下：
 *
 * N行注册数据以空格分隔，四项数依次表示：App名称、优先级、起始时间、结束时间
 * 优先级1~5，数字越大，优先级越高
 * 时间格式 HH:MM，小时和分钟都是两位，不足两位前面补0
 * 起始时间需小于结束时间，否则注册不上
 * 注册信息中的时间段包含起始时间点，不包含结束时间点
 */
public class E2024_手机防沉迷系统 {
    static class App {
        String name;
        int priority;
        int start;
        int end;

        App(String name, int priority, int start, int end) {
            this.name = name;
            this.priority = priority;
            this.start = start;
            this.end = end;
        }
    }

    // "HH:MM" -> minutes
    static int toMin(String t) {
        String[] sp = t.split(":");
        return Integer.parseInt(sp[0]) * 60 + Integer.parseInt(sp[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        List<App> apps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] sp = sc.nextLine().split(" ");
            String name = sp[0];
            int priority = Integer.parseInt(sp[1]);
            int start = toMin(sp[2]);
            int end = toMin(sp[3]);

            // 起始必须小于结束，否则无效
            if (start < end) {
                apps.add(new App(name, priority, start, end));
            }
        }

        String query = sc.nextLine().trim();
        int q = toMin(query);

        // owner[i] 表示第 i 分钟被哪个 App 占用
        String[] owner = new String[24 * 60];
        int[] pri = new int[24 * 60];

        Arrays.fill(owner, "NA");
        Arrays.fill(pri, -1);

        // 按优先级排序（低 -> 高）
        apps.sort(Comparator.comparingInt(a -> a.priority));

        for (App app : apps) {
            for (int t = app.start; t < app.end; t++) {
                // 只有当前优先级更高才覆盖
                if (app.priority > pri[t]) {
                    pri[t] = app.priority;
                    owner[t] = app.name;
                }
            }
        }

        System.out.println(owner[q]);
    }
}
