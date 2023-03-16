package priv.pront.code.lanqiao.competition.course;

import java.util.Scanner;
import java.lang.*;
/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-16 14:37
 */import java.util.*;

// fixme 优先级队列方法错误
public class Main8 {
    static class PII implements Comparable<PII> {
        long first;
        int second;

        PII(long first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(PII other) {
            return Long.compare(other.first, this.first);
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ans = 0;
        PriorityQueue<PII> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            long t = scanner.nextLong();
            if (t != 1) {
                q.add(new PII(t, i));
            }
        }

        while (!q.isEmpty()) {
            long t = q.peek().first;
            int r = q.peek().second;
            q.poll();
            long l = (long)Math.sqrt(t / 2 + 1);
            if (l != 1) {
                q.add(new PII(l, r));
            }

            while (!q.isEmpty() && q.peek().first == t && q.peek().second == r - 1) {
                r--;
                q.poll();
                if (l != 1) {
                    q.add(new PII(l, r));
                }
            }
            ans++;
        }
        System.out.println(ans);
    }
}

