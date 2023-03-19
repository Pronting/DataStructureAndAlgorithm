package priv.pront.code.lanqiao.competition;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-20 13:52
 */
public class 完美的代价 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        int[] arr = new int[26];
        int single = 0;
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                single++;
            }
        }
        if (single > 1) {
            System.out.println("Impossible");
            return;
        }
        System.out.println(getResult(word));
    }

    public static int getResult(String str) {
        if (str.length() == 1 || str.length() == 2) {
            return 0;
        }

        int tmp = str.lastIndexOf(str.charAt(0));//获取首字符对应的字符在此字符串中最后一次出现处的索引
        if (tmp == 0) {
            return str.length() / 2 + getResult(str.substring(1));
        } else {
            //移除首字母及其对应字母，返回将tmp位置的字符移动到末位置的次数
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(tmp);
            sb.deleteCharAt(0);
            return str.length() - tmp - 1 + getResult(sb.toString());
        }
    }
}
