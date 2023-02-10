package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-10 17:40
 */
public class L343_IntegerBreak {


//    dp
    public int integerBreak(int n) {
        int[] dp = new int [n + 1];
        dp[2] = 1;
        for(int i = 3; i<= n;i++){
            for(int j = 1;j< i-1;j++){
                dp[i] = Math.max(dp[i],Math.max(j * (i-j),j * dp[i-j]));
            }
        }
        return dp[n];
    }

//    !贪心+ 数学
    public int integerBreak2(int n) {
        int result =1;
        if( n ==2){
            return 1;
        }
        if(n ==3){
            return 2;
        }
        if(n ==4){
            return 4;
        }
        while(n>4){
            result *=3;
            n-=3;
        }
        result *=n;
        return result;
    }
}
