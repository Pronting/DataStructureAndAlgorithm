package priv.pront.code.lanqiao.competition;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-03 09:18
 */
public class Main1 {

    public static void main(String[] args) {
        int n = 2023;
        while (true) {
            String hex_n = Integer.toHexString(n).toUpperCase();
            if (hex_n.matches("[ABCDEF]+")) {
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}
