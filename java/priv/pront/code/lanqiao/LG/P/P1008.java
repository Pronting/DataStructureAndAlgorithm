package priv.pront.code.lanqiao.LG.P;

import java.util.HashSet;

/**
 * @Description: 三连击
 * @Author: pront
 * @Time:2022-11-24 20:14
 */
public class P1008 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x, y;
        String string;
        HashSet<Character> set = new HashSet<>();
        for (int i = 123; i <= 987 / 3; i++) {//因为3倍的i最大不能超过987，所以直接限制
            y = 2 * i;
            x = (i * 3);
            string = i + "" + y + "" + x;
            for (int k = 0; k < 9; k++) {
                if (string.charAt(k) != '0')//题目要求只能1到9
                    set.add(string.charAt(k));
            }
            if (set.size() == 9) {
                System.out.println(i + " " + y + " " + x);
            }
            set.clear();
            //最后只需要循环206次，只是每次都要循环9次加入hashset
        }
    }
}
