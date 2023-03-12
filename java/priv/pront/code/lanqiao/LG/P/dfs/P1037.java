package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-11 19:46
 */
public class P1037 {

    public static void main(String[] args) {
        Map<Integer, Integer> rulerMap = new HashMap<>();
        Set<String> numSet = new HashSet<>();

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        char[] chs = n.toCharArray();
//        把本身添加进去
        numSet.add(n);
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            rulerMap.put(scanner.nextInt(), scanner.nextInt());
        }
        for (Map.Entry<Integer, Integer> cur : rulerMap.entrySet()) {
            for (int i = 0; i < chs.length; i++) {
//            如果符合这条规则
                if (chs[i] == cur.getKey()) {
//                    chs[i] = cur.getValue();
                }
            }
        }
        System.out.println(numSet.size());
    }
}
