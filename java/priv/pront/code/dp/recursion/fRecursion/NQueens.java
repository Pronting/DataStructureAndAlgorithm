package priv.pront.code.dp.recursion.fRecursion;

/**
 * @Description: N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，
 * 也不在同一条斜线上。 给定一个整数n，返回n皇后的摆法有多少种。 n=1，返回1。
 * n=2或3，2皇后和3皇后问题无论怎么摆都不行，返回0。 n=8，返回92。
 * @Author: pront
 * @Time:2022-09-05 11:29
 */
public class NQueens {

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        //record[i] -->i行的皇后，放在了第几列
        int[] record = new int[n];
        return process1(0, record, n);
    }

    /**
     * record[0...i-1]的皇后，一定不共行、列、斜线
     * @param i 目前来到第i行
     * @param record record[0...i-1]表示之前放过皇后位置
     * @param n 整体一共有多少行
     * @return 摆完所有的皇后，合理的摆法有多少种
     */
    public static int process1(int i, int[] record, int n) {
        if (i == n) {
//            终止行
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
//            当前i行的皇后，放在j列，会不会和之前的(0...i-1)行的皇后，共行共列共斜线
//            如果是，认为有效
//            如果不是，认为无效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
            return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) { //之前某个k行的皇后
//            斜率为45°
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
            return true;
    }


//    请不要超过32皇后问题
public static int num2(int n) {
    if (n < 1 || n > 32) {
        return 0;
    }
    int upperLim = n == 32 ? -1 : (1 << n) - 1;
    return process2(upperLim, 0, 0, 0);
}

    public static int process2(int upperLim, int colLim, int leftDiaLim,
                               int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
