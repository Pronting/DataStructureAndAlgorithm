package priv.pront.code.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

        public static int maxVowels(String s, int k) {
            Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
            char[] chs = s.toCharArray();
            int ans = 0, count = 0;
            int l = 0, r = 0;
            while(l <= r){
                if(r - l == k){
                    ans = Math.max(count, ans);
                    if(set.contains(chs[l++])) count--;
                    if(set.contains(chs[r++])) count++;
                    if(r == chs.length) break;
                }else if(r - l < k){
                    if(set.contains(chs[r++])) count++;
                }
            }
            return ans;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            maxVowels("baciiidef", 3);
        }
}
