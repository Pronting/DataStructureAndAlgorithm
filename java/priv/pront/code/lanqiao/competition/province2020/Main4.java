package priv.pront.code.lanqiao.competition.province2020;

/**
 * @Description: 新冠疫情由新冠病毒引起，最近在 A 国蔓延，为了尽快控制疫情，A 国准
 * 备给大量民众进病毒核酸检测。
 * 然而，用于检测的试剂盒紧缺。
 * 为了解决这一困难，科学家想了一个办法：合并检测。即将从多个人（k
 * 个）采集的标本放到同一个试剂盒中进行检测。如果结果为阴性，则说明这 k
 * 个人都是阴性，用一个试剂盒完成了 k 个人的检测。如果结果为阳性，则说明
 * 至少有一个人为阳性，需要将这 k 个人的样本全部重新独立检测（从理论上看，
 * 如果检测前 k − 1 个人都是阴性可以推断出第 k 个人是阳性，但是在实际操作中
 * 不会利用此推断，而是将 k 个人独立检测），加上最开始的合并检测，一共使用
 * 了 k + 1 个试剂盒完成了 k 个人的检测。
 * A 国估计被测的民众的感染率大概是 1%，呈均匀分布。请问 k 取多少能
 * 最节省试剂盒？
 *
 *
 * ————————————————
 * 版权声明：本文为CSDN博主「肖有量」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_43449564/article/details/109094410
 * @Author: pront
 * @Time:2023-03-12 14:26
 */
public class Main4 {

    public static void main(String[] args) {
        int MAX = 10000, min = 0x7ffffff, res = 0;
        for (int i = 2; i <= MAX; i++) {
            int cnt = MAX / i + MAX / 100 * i + (MAX % i == 0? 0: 1);
            if (cnt < min) {
                min = cnt;
                res = i;
            }
        }
        System.out.print(res);
    }
}
