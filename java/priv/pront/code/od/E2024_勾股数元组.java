package priv.pront.code.od;

import java.util.Scanner;

public class E2024_勾股数元组 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = n; i <= m; i++){
            for(int j = i + 1; j <= m; j++){
                long target = (long)i * i + (long) j * j;
                int k = (int) Math.sqrt(target);
                if(k <= m && (long) k * k == target && areCompare(i, j, k)){
                    System.out.println(i + " " + j + " " + k);
                }
            }
        }
    }

    private static boolean areCompare(int i , int j, int k){
        return gcd(i, j) && gcd(i, k) && gcd(j, k);
    }

    private static boolean gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 1;
    }



}
