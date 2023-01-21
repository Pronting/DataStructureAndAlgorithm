package priv.pront.code.structure.binaryTree;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-16 21:29
 */
public class Main {


    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        double salary = scanner.nextDouble();
        double monthSalary = scanner.nextDouble();
        f(name,salary,monthSalary);
    }

    private static void f(String name,double salary,double mouthSalary){
        DecimalFormat df = new DecimalFormat("0.00");
        double res = salary + 0.15* mouthSalary;
        System.out.println("TOTAL = R$ " + res);
    }
}

