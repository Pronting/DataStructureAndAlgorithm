package priv.pront.code.algorithm.greedy;

/**
 * @Description: 路灯问题
 * @Author: pront
 * @Time:2023-01-15 15:48
 */
public class Light {

    public static int minLight1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        char[] help = new char[str.length + 2];
        help[0] = '.';
        help[str.length] = '.';
        for (int i = 0; i < str.length; i++) {
            help[i + 1] = str[i];
        }
        return process(help, 1, true);
    }

    // 当前来到了i位置
    // 函数潜台词：help[0..i-2]上都已经点亮了
    // pre表示i-1位置是否点亮
    // 返回如果把所有位置都点亮，help[i..最后]需要几盏灯
    // process(help, i, true)：表示help[0..i-2]上都已经点亮了，i-1位置也点亮的情况下，help[i..最后]需要几盏灯
    // process(help, i, false)：表示help[0..i-2]上都已经点亮了，但是i-1位置没亮的情况下，help[i..最后]需要几盏灯
    public static int process(char[] help, int i, boolean pre) {
        if (i == help.length) {
            return 0;
        }
        if (i == help.length - 1) {
            return pre ? 0 : Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        int restLight = 0;
        if (pre) {
            if (help[i] == '.') {
                restLight = process(help, i + 1, true);
                if (restLight != Integer.MAX_VALUE) {
                    ans = Math.min(ans, restLight);
                }
            } else {
                restLight = process(help, i + 1, false);
                if (restLight != Integer.MAX_VALUE) {
                    ans = Math.min(ans, restLight);
                }
                restLight = process(help, i + 2, true);
                if (restLight != Integer.MAX_VALUE) {
                    ans = Math.min(ans, restLight + 1);
                }
            }
        } else {
            restLight = process(help, i + 2, true);
            if (restLight != Integer.MAX_VALUE) {
                ans = Math.min(ans, restLight + 1);
            }
        }
        return ans;
    }

    ///    FIXME DP 结果不匹配 O(1)
    public static int minLight2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        char[] help = new char[str.length + 2];
        help[0] = '.';
        help[str.length] = '.';
        for (int i = 0; i < str.length; i++) {
            help[i + 1] = str[i];
        }
        int[][] dp = new int[help.length + 1][2];
        dp[help.length][0] = 0;
        dp[help.length][1] = 0;
        dp[help.length - 1][0] = Integer.MAX_VALUE;
        dp[help.length - 1][1] = 0;
        for (int i = help.length - 2; i >= 1; i--) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            int restLight = 0;
            if (help[i] == '.') {
                restLight = dp[i + 1][1];
                if (restLight != Integer.MAX_VALUE) {
                    dp[i][1] = Math.min(dp[i][1], restLight);
                }
            } else {
                restLight = dp[i + 1][0];
                if (restLight != Integer.MAX_VALUE) {
                    dp[i][1] = Math.min(dp[i][1], restLight);
                }
                restLight = dp[i + 2][1];
                if (restLight != Integer.MAX_VALUE) {
                    dp[i][1] = Math.min(dp[i][1], restLight + 1);
                }
            }
            restLight = dp[i + 2][1];
            if (restLight != Integer.MAX_VALUE) {
                dp[i][0] = Math.min(dp[i][0], restLight + 1);
            }
        }
        return dp[1][1];
    }


    private static int minLight3(String s) {
        char[] str = s.toCharArray();
        int index = 0;

        int light = 0;
//        当前来到i位置，一定要保证之前的等，彻底不会影响到i位置
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else { // str[index] == '.'
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {  //如果下面有位置
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }

    public static void main(String[] args) {
        String test1 = "...X.X.X..XX.XX.X.X.X.X.XX.XXX.X.XXX.XX";
        String test2 = "........X.........";
        System.out.println(minLight1(test1));
        System.out.println(minLight2(test1));
        System.out.println(minLight3(test1));
        System.out.println("===========================");

        System.out.println(minLight1(test2));
        System.out.println(minLight2(test2));
        System.out.println(minLight3(test2));
    }
}
