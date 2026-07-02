package priv.pront.code.od;

import java.util.*;

/**
 * 静态扫描可以快速识别源代码的缺陷，静态扫描的结果以扫描报告作为输出：
 *
 * 文件扫描的成本和文件大小相关，如果文件大小为N，则扫描成本为N个金币
 * 扫描报告的缓存成本和文件大小无关，每缓存一个报告需要M个金币
 * 扫描报告缓存后，后继再碰到该文件则不需要扫描成本，直接获取缓存结果
 * 给出源代码文件标识序列和文件大小序列，求解采用合理的缓存策略，最少需要的金币数。
 *
 * 输入描述
 * 第一行为缓存一个报告金币数M，L<= M <= 100
 *
 * 第二行为文件标识序列：F1,F2,F3,....,Fn。
 *
 * 第三行为文件大小序列：S1,S2,S3,....,Sn。
 *
 *
 *
 * 备注：
 *
 * 1 <= N <= 10000
 * 1 <= Fi <= 1000
 * 1 <= Si <= 10
 * 输出描述
 * 采用合理的缓存策略，需要的最少金币数.
 */
public class E2024_静态扫描 {

    static int k = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        int M = Integer.parseInt(sc.nextLine());
        String[] sp = sc.nextLine().split(" ");
        String[] cost = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < sp.length; i++) {
            cnt[Integer.parseInt(sp[i])]++;
            set.add(sp[i]);
            map.put(Integer.parseInt(sp[i]), Integer.parseInt(cost[i]));
        }

        int sum = 0;
        Set<String> cache = new HashSet<>();
        for(String str : set){
            if(cache.contains(str)) continue;
            int count = cnt[Integer.parseInt(str)];
            int cos = Math.min(M + map.get(Integer.parseInt(str)), count * map.get(Integer.parseInt(str)));
            if(cos == M) cache.add(str);
            sum += cos;
        }
        System.out.println(sum);
    }
}
