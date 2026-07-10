package priv.pront.code.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E2024_统计二元组的个数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取 n 和 m
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        // 统计数组 A 中每个数字的出现次数
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // 计算 B 数组中数字在 A 中出现的次数
        int result = 0;
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            if (freqMap.containsKey(num)) {
                result += freqMap.get(num);
            }
        }
        // 输出结果
        System.out.println(result);
    }
}
