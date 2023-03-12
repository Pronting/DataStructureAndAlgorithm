package priv.pront.code.lanqiao.competition.province2020;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-12 12:16
 */
public class Main3 {

    public static void main(String[] args) {

//        int min = (10000 / 300) * 2 * 60;
//        int res = 10000 % 300;
//        System.out.println(res);

        int i = -60, j, n = 10000 - 300;
        while (n > 0) {
            n += 300;
            i += 60;
            for (j = i + 60; i < j && n > 0; i++)
                n -= 10;
        }
        System.out.print(i);


    }
}
