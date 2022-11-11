package priv.pront.code.dp;

public class Code02_CoinsMin {

	public static int minCoins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		return process(arr, 0, aim);
	}

	public static int process(int[] arr, int i, int rest) {
		if (i == arr.length) {
			return rest == 0 ? 0 : -1;
		}
		// 最少张数，初始时为-1，因为还没找到有效解
		int res = -1;
		// 依次尝试使用当前面值(arr[i])0张、1张、k张，但不能超过rest
		for (int k = 0; k * arr[i] <= rest; k++) {
			// 使用了k张arr[i]，剩下的钱为rest - k * arr[i]
			// 交给剩下的面值去搞定(arr[i+1..N-1])
			int next = process(arr, i + 1, rest - k * arr[i]);
			if (next != -1) { // 说明这个后续过程有效
				res = res == -1 ? next + k : Math.min(res, next + k);
			}
		}
		return res;
	}

	public static int minCoins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int N = arr.length;
		int[][] dp = new int[N + 1][aim + 1];
		// 设置最后一排的值，除了dp[N][0]为0之外，其他都是-1
		for (int col = 1; col <= aim; col++) {
			dp[N][col] = -1;
		}
		for (int i = N - 1; i >= 0; i--) { // 从底往上计算每一行
			for (int rest = 0; rest <= aim; rest++) { // 每一行都从左往右
				dp[i][rest] = -1; // 初始时先设置dp[i][rest]的值无效
				if (dp[i + 1][rest] != -1) { // 下面的值如果有效
					dp[i][rest] = dp[i + 1][rest]; // dp[i][rest]的值先设置成下面的值
				}
				// 左边的位置不越界并且有效
				if (rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1) {
					if (dp[i][rest] == -1) { // 如果之前下面的值无效
						dp[i][rest] = dp[i][rest - arr[i]] + 1;
					} else { // 说明下面和左边的值都有效，取最小的
						dp[i][rest] = Math.min(dp[i][rest],
								dp[i][rest - arr[i]] + 1);
					}
				}
			}
		}
		return dp[0][aim];
	}

	// for test
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
			if (minCoins1(arr, aim) != minCoins2(arr, aim)) {
				System.out.println("ooops!");
				break;
			}
		}
	}
}
