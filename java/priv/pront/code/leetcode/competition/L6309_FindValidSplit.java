package priv.pront.code.leetcode.competition;

import java.math.BigInteger;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-05 11:20
 */
public class L6309_FindValidSplit {

    public int findValidSplit(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }
        int[] pre = new int[nums.length - 1];
        int[] pos = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i;
            int preSum = 1;
            int posSum = 1;
            int k = i + 1;
            while (j >= 0) {
                preSum *= nums[j--];
            }
            while (k < nums.length) {
                posSum *= nums[k++];
            }
            pre[i] = preSum;
            pos[i] = posSum;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (check(pre[i], pos[i])) {
                return i;
            }
        }
        return -1;
    }


    public int findValidSplit2(int[] nums) {
        int n = nums.length;
        BigInteger prod = BigInteger.ONE;
        BigInteger[] prods = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            prods[i] = prod;
            prod = prod.multiply(BigInteger.valueOf(nums[i]));
        }
        prod = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            prod = prod.multiply(BigInteger.valueOf(nums[i]));
            BigInteger gcd = prod.gcd(prods[i]);
            if (gcd.equals(BigInteger.ONE)) {
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean check(int num, int num1) {
        int big = num > num1 ? num : num1;
        int small = num < num1 ? num : num1;
        for (int i = 2; i <= small; i++) {
            if (small % i == 0 && big % i == 0) {
                return false;
            }
        }
        return true;
    }

        public static void main (String[]args){
        System.out.println(new L6309_FindValidSplit().findValidSplit2(new int[]{4, 7, 8, 15, 3, 5}));
//            System.out.println(225 / 224);

        }
    }
