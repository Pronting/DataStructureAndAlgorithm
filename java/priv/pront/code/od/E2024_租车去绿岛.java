package priv.pront.code.od;

import java.util.Arrays;
import java.util.Scanner;

public class E2024_租车去绿岛 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int l = 0, r = n - 1;
        int ans = 0;
        Arrays.sort(arr);
        while(l <= r){
            if(arr[r] + arr[l] <= m){
                r--;
                l++;
            }else{
                r--;;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
