package priv.pront.code.lanqiao.LG.P;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: 多项式输出
 * @Author: pront
 * @Time:2022-12-02 10:26
 */
public class P1067 {

    public static List<String> numberList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int frequency = scan.nextInt();
        for (int i = 0; i <= frequency + 1; i++) {
            numberList.add(scan.nextLine());
        }
        preTreatment(numberList);
        System.out.println(print(frequency + 1, numberList));


    }

    /**
     * 多项式输出
     *
     * @param frequency  次数
     * @param numberList 预处理的数字数组
     */
    private static String print(int frequency, List<String> numberList) {
        String ans = "";
        for (int i = 0; i <= frequency; i++) {
            String cur = numberList.get(i);
            if (!cur.equals("+0") && !cur.equals("")) {
                if (cur.equals("-1")) {
                    ans += (frequency - i == 0 ? "-1" : "-") + (frequency - i == 0 ? "" : "x") + (frequency - i == 0 ? "" : "^") + (frequency - i == 0 ? "" : (frequency - i));
                }else if (cur.equals("+1")) {
                    ans += (frequency - i == 0 ? "+1" : "+") + (frequency - i == 0 ? "" : "x") + (frequency - i == 0 ? "" : "^") + (frequency - i == 0 ? "" : (frequency - i));
                } else {
                    ans += cur + (frequency - i == 0 ? "" : "x") + (frequency - i == 0 ? "" : "^") + (frequency - i == 0 ? "" : (frequency - i));
                }
            }
        }
        ans = ans.charAt(0) == '-' ? ans : ans.substring(1);
        return ans;
    }

    private static void preTreatment(List<String> numberList) {
        for (int i = 0; i < numberList.size(); i++) {
            if (!numberList.get(i).equals("") && !numberList.get(i).substring(0, 1).equals("-")) {
                numberList.set(i, "+" + numberList.get(i));
            }
        }
    }
}
