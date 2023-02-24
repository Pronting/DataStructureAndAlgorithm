package priv.pront.code.leetcode.str;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-23 21:12
 */
//TODO
public class L564_NearestPalindromic {

    public static String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return Integer.parseInt(n) - 1 + "";
        }
        int oldValue = Integer.parseInt(n);
        // update
        int mid = n.length() / 2;
        int rightIndex = n.length() - 1;
        char[] chs = n.toCharArray();
        if ((n.length() & 1) > 0) {
            for (int i = 0; i < mid && rightIndex > mid; i++, rightIndex--) {
                chs[rightIndex] = chs[i];
            }
        } else {
            int midLeft = mid - 1;
            for (int i = 0; i <= midLeft && rightIndex >= mid; i++, rightIndex--) {
                chs[rightIndex] = chs[i];
            }
        }
        int newValue = Integer.parseInt(new String(chs));
        int cost1 = Math.abs(oldValue - newValue);
        return new String(chs);
    }


    public static void main(String[] args) {
        String s = "1234";
        System.out.println(nearestPalindromic(s));
    }
}
