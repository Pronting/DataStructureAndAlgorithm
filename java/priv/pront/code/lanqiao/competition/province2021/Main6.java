package priv.pront.code.lanqiao.competition.province2021;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-14 10:52
 */
public class Main6 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int score = 0;
        int jige = 0;
        int youxiu = 0;
        for(int i = 0; i < n; i++){
             score = scanner.nextInt();
            if(score >= 85){
                youxiu++;
            }
            if(score >= 60){
                jige++;
            }
        }
        double jigePrecent = 100.0 * jige / n;
        double youxiuPrecent = 100.0 * youxiu / n;
        System.out.println(Math.round(jigePrecent) + "%");
        System.out.println(Math.round(youxiuPrecent) + "%");
    }
}
