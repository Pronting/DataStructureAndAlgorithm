package priv.pront.code.lanqiao.competition.province2020;

import java.util.Scanner;

/**
 * @Description: 输出三行，每行一个整数，分别表示大写字母、小写字母和数字的个数。
 * @Author: pront
 * @Time:2023-03-12 14:43
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int xiaoxie = 0;
        int daxie = 0;
        int num = 0;
        char[] chs = word.toCharArray();
        for(int i = 0; i< chs.length; i++){
            if (chs[i] - 'a' >= 0 && chs[i] - 'a' < 26) {
                xiaoxie++;
            } else if (chs[i] - 'A' >= 0 && chs[i] - 'A' < 26) {
                daxie++;
            }else if(chs[i] - '0' >= 0 && chs[i] - '0' < 10){
                num++;
            }
        }
        System.out.println(daxie);
        System.out.println(xiaoxie);
        System.out.println(num);
    }
}
