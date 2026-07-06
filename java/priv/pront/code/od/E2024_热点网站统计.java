package priv.pront.code.od;

import java.util.*;

public class E2024_热点网站统计 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> countMap = new HashMap<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();

            // 如果是数字：输出TopN
            if (isNumber(line)) {
                int n = Integer.parseInt(line);

                List<String> list = new ArrayList<>(countMap.keySet());

                list.sort((a, b) -> {
                    int ca = countMap.get(a);
                    int cb = countMap.get(b);

                    if (ca != cb) {
                        return cb - ca; // 访问次数降序
                    }
                    return a.compareTo(b); // 字典序升序
                });

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n && i < list.size(); i++) {
                    if (i > 0) sb.append(",");
                    sb.append(list.get(i));
                }

                System.out.println(sb);

            } else {
                // URL：计数 +1
                countMap.put(line, countMap.getOrDefault(line, 0) + 1);
            }
        }
    }

    private static boolean isNumber(String s) {
        return s != null && s.matches("\\d+");
    }
}
