package priv.pront.code.lanqiao.competition.course;

import java.math.BigInteger;

public class 双阶乘 {
    public static void main(String[] args) {
        BigInteger sum = new BigInteger("1");
        for (int i = 2021; i >= 1; i -= 2) {
            sum = sum.multiply(new BigInteger(i + ""));
        }
        String res = sum + "";
        System.out.println(res.substring(res.length() - 5));
//        59375
    }
}
