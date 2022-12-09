package priv.pront.code.algorithm.dp.recursion;

/**
 * @Description: 一段数字能转换为多少种字母
 * @Author: pront
 * @Time:2022-11-25 17:01
 */
public class NumToStringWays {

    private static int covertWays(int num) {
        if (num < 1) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }

    /**
     * 0~index-1 已经转换完毕，并且转化正确
     * str[index...] 能转换出多少种有效的字符串表达
     * @param str
     * @param index
     * @return
     */
    private static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = process(str, index + 1);
        if (index == str.length - 1) {
//            除了index之外，后续没有字符串了
            return res;
        }
//        index+1依然没有越界
        if (((str[index] - '0') * 10 + str[index + 1] - '0') < 27) {
            res += process(str, index + 2);
        }
        return res;
    }


    private static int dpWays(int num) {
        if (num < 1) {
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();
        int[] dp = new int[str.length + 1];
        dp[str.length] = 1;
        dp[str.length - 1] = str[str.length - 1] == '0' ? 0 : 1;
        for (int i = str.length - 2; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1] + (((str[i] - '0') * 10 + str[i + 1] - '0') < 27 ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int test = 111143311;
        System.out.println(covertWays(test));
        System.out.println(dpWays(test));
    }
}
