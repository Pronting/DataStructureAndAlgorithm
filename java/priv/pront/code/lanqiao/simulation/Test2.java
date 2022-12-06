package priv.pront.code.lanqiao.simulation;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-03 14:47
 */
public class Test2 {

    private static Set<String> set = new HashSet<>();
    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int times = s.nextInt();
        for (int i = 0; i <= times; i++) {
            String cur = s.nextLine();
            if (!set.contains(cur)) {
                queue.add(cur);
                set.add(cur);
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
