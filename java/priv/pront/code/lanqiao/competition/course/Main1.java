package priv.pront.code.lanqiao.competition.course;/*
* 在上面的例子中，小蓝的打印机没办法打印到边缘，所以边缘至少要裁
4 次。另外，小蓝每次只能裁一张纸，不能重叠或者拼起来裁。

如果小蓝要用一张纸打印出
20 行
22 列共
440 个二维码，他至少需要裁多少次?
* */

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){
        String[] arr = {"443","LLLV"};
        Scanner scanner = new Scanner(System.in);
        String T = scanner.next();
        System.out.println(arr[T.charAt(0) - 'A']);
    }
}
