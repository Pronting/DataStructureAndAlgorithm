package priv.pront.code.lanqiao.competition.province2020;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-12 14:33
 */
public class Main5 {

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int k = 0;
        int a = 0;
        while (i <= 2) {
            i++;
            a += 4;
            while(j <=5){
                j++;
                while (k <= 6) {
                    k++;
                    a += 5;
                }
                a += 7;
            }
            a += 8;
        }
        a += 9;
        System.out.println(a);

    }
}
