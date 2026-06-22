package priv.pront.code.nk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * 牛牛有一个长度为n的数组，牛妹给出m个询问，询问有2种类型：
 * 1 l r：询问区间l,r内有多少子序列的乘积为奇数
 * 2 l r：询问区间l,r内有多少子序列的乘积为偶数
 *
 * 思路：
 *   - 子序列乘积为奇数 <=> 子序列中所有元素都是奇数
 *   - 设区间内奇数个数为 odd，偶数个数为 even = len - odd，长度 len
 *   - 奇数乘积的非空子序列数 = 2^odd - 1  （从 odd 个奇数中选非空子集）
 *   - 偶数乘积的非空子序列数 = (2^len - 1) - (2^odd - 1) = 2^len - 2^odd
 *   - 用前缀和 O(1) 求 odd，用快速幂 + 模运算
 */
public class FormatOutput {

    private static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;

        // 前缀和：oddPrefix[i] 表示前 i 个元素中奇数的个数（1-indexed）
        int[] oddPrefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            long val = (long) in.nval;
            oddPrefix[i] = oddPrefix[i - 1] + ((val & 1L) == 1L ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            in.nextToken();
            int type = (int) in.nval;
            in.nextToken();
            int l = (int) in.nval;
            in.nextToken();
            int r = (int) in.nval;

            int odd = oddPrefix[r] - oddPrefix[l - 1];
            int len = r - l + 1;

            long powOdd = pow2(odd);
            long powLen = pow2(len);

            long ans;
            if (type == 1) {
                // 子序列乘积为奇数的个数：2^odd - 1
                ans = (powOdd - 1 + MOD) % MOD;
            } else {
                // 子序列乘积为偶数的个数：2^len - 2^odd
                ans = (powLen - powOdd + MOD) % MOD;
            }
            sb.append(ans).append('\n');
        }
        out.print(sb);
        out.flush();
        out.close();
    }

    /**
     * 快速幂：计算 2^k mod (10^9+7)
     * 2 <= 2 * 10^5，用 long 足够，无需快速幂也能在 O(k) 完成，
     * 但快速幂为 O(log k) 更稳妥。
     */
    private static long pow2(int k) {
        long result = 1L;
        long base = 2L;
        int exp = k;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}