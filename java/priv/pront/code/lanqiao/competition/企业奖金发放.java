package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description: 企业发放的奖金根据利润提成。利润低于或等于10万元时，奖金可提10%；
 * 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，
 * 可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万元到60万元之间时高于40万元的部分，
 * 可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%；高于100万元时，超过100万元的部分按1%提成。
 * 从键盘输入当月利润，求应发放奖金总数？（保留两位小数）利润的大小在double以内
 * @Author: pront
 * @Time:2023-03-22 10:02
 */
public class 企业奖金发放 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double profit = scanner.nextDouble();
        double res = printBonus(profit);
        System.out.println(String.format("%.2f", res));
    }
    private static double printBonus(double profit) {
        if(profit<=100000) {
            return profit*0.1;
        }
        else if(profit<=200000) {
            return printBonus(100000)+(profit-100000)*0.075;
        }
        else if(profit<=400000) {
            return printBonus(200000)+(profit-200000)*0.05;
        }
        else if(profit<=600000) {
            return printBonus(400000)+(profit-400000)*0.03;
        }
        else if(profit<=1000000) {
            return printBonus(600000)+(profit-600000)*0.015;
        }
        else {
            return printBonus(1000000)+(profit-1000000)*0.01;
        }
    }
}
