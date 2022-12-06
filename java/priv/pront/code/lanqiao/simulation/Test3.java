package priv.pront.code.lanqiao.simulation;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-03 14:58
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        int[] position = getPosition(word);
        int x = position[0];
        int y = position[1];
        System.out.println(x + " " + y);
    }

    private static int[] getPosition(String word) {
        int[] arr = new int[]{0, 0};
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'U') {
                arr[0]--;
            } else if (word.charAt(i) == 'D') {
                arr[0]++;
            } else if (word.charAt(i) == 'L') {
                arr[1]--;
            } else if (word.charAt(i) == 'R') {
                arr[1]++;
            }
        }
        return arr;
    }
}
