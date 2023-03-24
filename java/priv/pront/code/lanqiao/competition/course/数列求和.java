package priv.pront.code.lanqiao.competition.course;

public class 数列求和 {
//    856830691
    public static void main(String[] args) {
        int[] dp = new int[20190324];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        System.out.println(dp[dp.length - 1]);

    }
}
