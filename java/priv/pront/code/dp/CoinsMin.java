package priv.pront.code.dp;

/**
 * @Description: 最小硬币数问题
 * 给定一个整数数组 代表持有的硬币面额
 * 请返回 组成 aim这么大的最小硬币数量
 * @Author: pront
 * @Time:2022-11-10 15:20
 */
public class CoinsMin {

    public static int getMinCoins1(int[] coinsArray, int aim) {
        return process1(coinsArray, 0, aim);
    }

    //    arr[index...] 组成rest 这么多钱，最少的硬币数量返回
    private static int process1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
//        rest > 0 并且 也有硬币
        int p1 = process1(arr, index + 1, rest);
        int p2Next = process1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2Next + 1;
            }
            if (p2Next == -1) {
                return p1;
            }
            return Math.min(p1, p2Next + 1);
        }
    }


    public static int getMinCoins2(int[] coinsArray, int aim) {
        int[][] dp = new int[coinsArray.length + 1][aim + 1];
        for (int i = 0; i <= coinsArray.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(coinsArray, 0, aim, dp);
    }

    private static int process2(int[] arr, int index, int rest, int[][] dp) {

        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }

//        缓存没命中
        if (rest == 0) {
            dp[index][rest] = 0;
        } else if (index == arr.length) {
            dp[index][rest] = -1;
        } else {
//        rest > 0 并且 也有硬币
            int p1 = process2(arr, index + 1, rest, dp);
            int p2Next = process2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2Next == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2Next + 1;
                } else if (p2Next == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[index][rest];
    }

    public static int getMinCoins3(int[] coinsArray, int aim) {
        int N = coinsArray.length;
        int[][] dp = new int[N + 1][aim + 1];

        for (int row = 0; row <= N; row++) {
            dp[row][0] = 0;
        }
        for (int col = 1; col <= aim; col++) {
            dp[N][col] = -1;
        }

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {

//        rest > 0 并且 也有硬币
                int p1 = dp[index + 1][rest];
                int p2Next = -1;
                if (dp[index + 1][rest - coinsArray[index]] >= 0) {
                    p2Next = dp[index + 1][rest - coinsArray[index]];
                }

                if (p1 == -1 && p2Next == -1) {
                    dp[index][rest] = -1;
                } else {
                    if (p1 == -1) {
                        dp[index][rest] = p2Next + 1;
                    }
                    if (p2Next == -1) {
                        dp[index][rest] = p1;
                    }
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[0][aim];
    }


    // for test 对数器
    public static int[] generateRandomArray(int len, int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        int len = 10;
        int max = 10;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(len, max);
            int aim = (int) (Math.random() * 3 * max) + max;
            if (getMinCoins1(arr, aim) != getMinCoins2(arr, aim) && getMinCoins2(arr, aim)!=getMinCoins3(arr,aim)) {
                System.out.println("ooops!");
                break;
            }
        }
    }
}
