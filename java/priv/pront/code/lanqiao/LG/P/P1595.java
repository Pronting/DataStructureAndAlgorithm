package priv.pront.code.lanqiao.LG.P;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-25 19:17
 */
public class P1595 {
    static Map<Integer, Integer> map = new HashMap<>();
    static Set<Integer> containsSet = new HashSet<>();
    static Map<Integer, List<Integer>> matchMap = new HashMap<>();

    private static int f(int n) {
        int count = 0;
//        1~n信封 初始化
        for (int i = 0; i < n; i++) {
            map.put(i, i + 20);
            containsSet.add(i + 20);
        }
//        1~n信封装信
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> current : map.entrySet()) {
                int xinfeng = current.getValue();
                if (xinfeng != n + 20) {
                    list.add(xinfeng);
                }
            }
            matchMap.put(n, list);
        }

//        排列错误的组合

//        for (int i = 1; i <= n; i++) {
//            List<Integer> xinfengs = matchMap.get(i);
//            int xin = xinfengs.remove(0);
//            containsSet.remove(xin);
//            count++;
//        }
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (Map.Entry<Integer, List<Integer>> cur : matchMap.entrySet()) {
                int xinfeng = cur.getKey();
                List<Integer> value = cur.getValue();
                for (int j = 0; j < value.size(); j++) {
                    if (!containsSet.isEmpty() && containsSet.contains(n + 20)) {
                        int remove = value.remove(index++);
                        containsSet.remove(remove);

                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int value = f(n);
        System.out.println(value);
    }
}
