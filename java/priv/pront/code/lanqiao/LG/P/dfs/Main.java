package priv.pront.code.lanqiao.LG.P.dfs;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-28 20:20
 */
public class Main {

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double a = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y2-y1),2));
        String res = "%.4f";
        System.out.println(res);


    }
}
