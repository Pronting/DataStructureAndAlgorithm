package priv.pront.code.leetcode.dp;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-06 22:39
 */
public class L1653_MinmumDeletions {

//    dp
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] left = new int[n];
        left[0] = (s.charAt(0)=='a'?0:1);
        int[] right = new int[n];
        right[n-1] = (s.charAt(n-1)=='b'?0:1);
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++) {
            left[i] = left[i-1]+((s.charAt(i)=='a'?0:1));
        }
        for(int i = n-2;i>=0;i--) {
            right[i] = right[i+1]+(s.charAt(i)=='b'?0:1);
        }
        for(int i = -1;i<n;i++) {
            int num = (i==-1?0:left[i])+(i==n-1?0:right[i+1]);
            ans = Math.min(ans, num);
        }

        return ans;
    }

    // 暴力解法
    public int minimumDeletions2(String s) {
        if(s.length() == 1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = -1; i < s.length(); i++){
            int count = 0;
            for(int j = i; j >= 0; j--){
                if(s.charAt(j) != 'a'){
                    count++;
                }
            }
            for(int k = i + 1;k < s.length(); k++){
                if(s.charAt(k) != 'b'){
                    count++;
                }
            }
            ans = Math.min(ans,count);
        }
        return ans;
    }
}
