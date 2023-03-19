package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 10:00
 */
public class 邮票面值设计 {

    static int N, K;
    static int[] curfvalue = new int[11];//current face value 当前计算的面值
    static int[] bestfvalue = new int[11];//best face value 最优面值（即当连续最大值达到最大的面值）
    static int max = Integer.MIN_VALUE;//记录连续最大的邮资值+1
    static int[] postage = new int[1000];//存放邮资值对应的邮票数量

    public static void main(String[] args) {
        //初始化参数
        init();
        //获取结果
        getResult();
        //打印最优面值和最大邮资值
        print();
    }

    private static void print() {
        for (int i = 1; i <= K; i++) {
            System.out.print(bestfvalue[i] + " ");
        }
        System.out.println();
        System.out.println("MAX=" + (max - 1));
    }

    private static void getResult() {
        //第一张面值一定为1，否则邮资值无法从1开始
        curfvalue[1] = 1;
        dp(1);
    }

    private static void dp(int x) {
        //这里的temp是获取到当前可以达到的最大邮资值+1
        int temp = getMax(x);
        //如果面值的种类到了我们输入的面值种类，则结束
        if (x == K) {
            return;
        }
        //下一张面值的范围为 ： 当前面值+1 ~ 当前最大邮资值+1
        for (int i = temp; i > curfvalue[x]; i--) {
            curfvalue[x + 1] = i;
            //加入下一张面值后重新计算可以达到的最大值
            dp(x + 1);
        }
    }

    private static int getMax(int x) {
        for (int i = 1; i < 1000; i++) {//这里要知道postage[0] = 0
            //初始化每个邮资值
            postage[i] = Integer.MAX_VALUE;
            //遍历每个当前有的面值
            for (int j = 1; j <= x; j++) {
                //邮资值必须大于面值，才有可能由面值构成
                if (i >= curfvalue[j]) {
                    //postage[i-curfvalue[j]] 表示的是 当前邮资值减去该面值后的邮资值所构成的邮票数（已经计算好的）
                    //+1是因为我们加上了这个面值后，邮资值就等于当前邮资值，所以相当于加了一张邮票
                    postage[i] = Math.min(postage[i], postage[i - curfvalue[j]] + 1);
                }
            }
            //如果邮资值构成的邮票数大于我们限制的最大邮票数
            if (postage[i] > N) {
                if (i > max) {
                    max = i;//更新连续最大邮资值+1
                    //将可以构成当前最大邮资值的相关面值进行存储
                    for (int j = 1; j <= x; j++) {
                        bestfvalue[j] = curfvalue[j];
                    }
                }
                return i;//此时返回的是最大邮资值+1，而不是最大邮资值
            }
        }
        return 0;
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
    }
}
