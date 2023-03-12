package priv.pront.code.lanqiao.competition.province2020;

import java.math.BigInteger;

/**
 * @Description: 7 月 1 日是建党日，从 1921 年到 2020 年，中国共产党已经带领中国人民
 * 走过了 99 年。
 * 请计算：7 2020 7^{2020}7
 * 2020
 *   mod 1921，其中 A mod B 表示 A 除以 B 的余数。
 * @Author: pront
 * @Time:2023-03-12 11:55
 */
public class Main1 {

    public static void main(String[] args) {
        System.out.println(new BigInteger("7").pow(2020).mod(new BigInteger("1921")));

//        System.out.println(% 1921);
    }
}
