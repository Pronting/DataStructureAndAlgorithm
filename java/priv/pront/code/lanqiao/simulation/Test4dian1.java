package priv.pront.code.lanqiao.simulation;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-03 15:46
 */
import java.util.Scanner;

public class Test4dian1 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            //截取当前位置至结尾的字符串，判断是否回文
            String tmp = s.substring(i);
            if(isOK(tmp)) {	//若是回文，用k记录i，退出for循环
                k = i;
                break;
            }
        }
        StringBuilder ss = new StringBuilder(s);
        while(k-- > 0) {	//添加字符到原字符串末尾
            ss.append(s.charAt(k));
        }
        System.out.println(ss.toString());
    }

    public static boolean isOK(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}

