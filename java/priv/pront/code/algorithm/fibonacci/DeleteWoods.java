package priv.pront.code.algorithm.fibonacci;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-01 13:04
 */
public class DeleteWoods {

    public static int minDelete(int m) {
        if (m < 4) {
            return 0;
        }
        int k_2 = 2;
        int k_1 = 3;
        int num = 3;
        while (k_2 + k_1 <= m) {
            num++;
            k_1 += k_2;
            k_2 = k_1 - k_2;
        }
        return m - num;
    }

    public static void main(String[] args) {
        int test = 8;
        System.out.println(minDelete(test));
    }
}
