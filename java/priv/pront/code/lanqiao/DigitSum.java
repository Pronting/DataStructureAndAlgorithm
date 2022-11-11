package priv.pront.code.lanqiao;

/**
 * @Description: 数位和
 * @Author: pront
 * @Time:2022-10-18 13:38
 */
public class DigitSum {

    private static int digitSum(int n) {
        if (n < 1 || n > 9999) {
            return -1;
        }
        int bit = getDigit(n, 1);
        int ten = getDigit(n, 2);
        int hundred = getDigit(n, 3);
        int thousand = getDigit(n, 4);
        return bit + ten + hundred + thousand;
    }

    private static int getDigit(int x, int d) {
        return ((x / (int) Math.pow(10, d - 1)) % 10);
    }


    public static void main(String[] args) {
        int n = digitSum(2222);
        System.out.println(n);
    }

}
