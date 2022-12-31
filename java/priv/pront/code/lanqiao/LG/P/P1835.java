package priv.pront.code.lanqiao.LG.P;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-21 22:18
 */
public class P1835 {

//    private static int primeCount(int L,int R){
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        for (int i =1; i <= R; i++) {
//            list.add(i);
//        }
//
//        list.set(1, 0);
//        int x = (int) Math.sqrt(R);
//        for (int i = 2; i <= x; i++) {
//            if (list.get(i) != 0) {
//                int a = i * i;
//                while (a <= R) {
//                    list.set(a, 0);
//                    a += i;
//                }
//            }
//        }
//        List<Integer> prime = list.stream().filter(i -> i != 0).collect(Collectors.toList());
//        List<Integer> resList = prime.stream().filter(i -> i >= L).collect(Collectors.toList());
//        int count = 0;
//        for (Integer integer : resList) {
//            count++;
//        }
//        return count;
//    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    static long nextLong() throws IOException {
        st.nextToken();
        return (long) st.nval;
    }

    public static void main(String[] args) throws IOException {
        long l = nextLong();
        long r = nextLong();
        l = l == 1 ? 2 : l; // 特判 l == 1 的情况

        // 先筛出 50000 以内的质数
        boolean[] isPrime = new boolean[50001];
        Arrays.fill(isPrime, true);
        int[] prime = new int[50000];
        int cnt = 0;
        for (int i = 2; i <= 50000; i++) {
            if (isPrime[i] == true) {
                prime[cnt] = i;
                cnt++;
            }
            for (int j = 0; j < cnt && i * prime[j] <= 50000; j++) {
                isPrime[i * prime[j]] = false;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }

        isPrime = new boolean[(int)(r - l + 1)];
        Arrays.fill(isPrime, true);
        // 枚举每一个选出来的质数
        for (int i = 0; i < cnt; i++) {
            // 从大于左区间的最小的 prime[i] 的倍数开始
            long start = Math.max((l + prime[i] - 1) / prime[i] * prime[i], prime[i] * 2);
            for (long j = start; j <= r; j += prime[i]) {
                isPrime[(int)(j - l)] = false;
            }
        }

        int ans = 0;
        for (int i = 0; i <= r - l; i++) {
            if (isPrime[i] == true) {
                ans++;
            }
        }
        pw.println(ans);
        pw.flush();
    }
}
