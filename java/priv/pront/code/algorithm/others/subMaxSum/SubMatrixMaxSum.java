package priv.pront.code.algorithm.others.subMaxSum;

/**
 * @Description: 子矩阵中最大和
 * @Author: pront
 * @Time:2023-01-04 11:27
 */
public class SubMatrixMaxSum {

    public static int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur;
        int[] s;
        for (int i = 0; i != m.length; i++) {  //开始的行号是i
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {   //结束的行号j ,i~j行是我讨论的范围
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(maxSum(matrix));

    }
}
