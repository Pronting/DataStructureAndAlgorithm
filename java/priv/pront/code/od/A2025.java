package priv.pront.code.od;

import java.util.*;

/**
 * AI识别到面板上有N（1 ≤ N ≤ 100）个指示灯，灯大小一样，任意两个之间无重叠。
 *
 * 由于AI识别误差，每次识别到的指示灯位置可能有差异，以4个坐标值描述AI识别的指示灯的大小和位置(左上角x1,y1，右下角x2,y2)，
 *
 * 请输出先行后列排序的指示灯的编号，排序规则：
 *
 * 每次在尚未排序的灯中挑选最高的灯作为的基准灯，
 * 找出和基准灯属于同一行所有的灯进行排序。两个灯高低偏差不超过灯半径算同一行（即两个灯坐标的差 ≤ 灯高度的一半）。
 */
public class A2025 {

    static class Item {
        int num;
        int x1, x2, y1, y2;

        public Item(int num, int x1, int y1, int x2, int y2) {
            this.num = num;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Item> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            list.add(new Item(num, x1, y1, x2, y2));
        }

        // 先按照 y 排序，方便每次找到最上面的灯
        list.sort((o1, o2) -> o1.y1 - o2.y1);

        List<Integer> ans = new ArrayList<>();

        while (!list.isEmpty()) {

            // 当前最上面的灯作为基准灯
            Item base = list.get(0);

            int height = base.y2 - base.y1;
            int limit = height / 2;

            List<Item> row = new ArrayList<>();

            Iterator<Item> it = list.iterator();

            while (it.hasNext()) {
                Item cur = it.next();

                if (Math.abs(cur.y1 - base.y1) <= limit) {
                    row.add(cur);
                    it.remove();
                }
            }

            // 同一行按 x 排序
            row.sort((o1, o2) -> o1.x1 - o2.x1);

            for (Item item : row) {
                ans.add(item.num);
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ans.get(i));
        }
    }
}
