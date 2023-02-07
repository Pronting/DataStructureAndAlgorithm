package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-07 14:01
 */
public class L70_ClimbStairs {

//    DP 空间O(N)
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

//    滚动数组 空间O(1)
public static  int climbStairs2(int n) {
    if(n ==1){
        return 1;
    }
    if(n ==2){
        return 2;
    }
    int q = 1;
    int p = 2;
    int per = 0;
    for(int i = 3;i<=n; ++i){
        per = q + p;
        q = p;
        p = per;

    }
    return per;
}

    public static void main(String[] args) {
        System.out.println(climbStairs2(3));
    }
}
