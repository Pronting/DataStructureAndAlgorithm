package priv.pront.code.lanqiao.LG;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: 后缀表达式
 * @Author: pront
 * @Time:2022-12-01 22:16
 */
public class P1175 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String value = scan.nextLine();
        middle(value);
    }

    private static void middle(String value) {
        String preValue = "";
        char[] chars = value.toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
//            如果是数字则直接输出
            if(chars[i] =='0'||chars[i] =='1'||chars[i] =='2'||chars[i] =='3'||chars[i] =='4'||chars[i] =='5'||chars[i] =='6'||chars[i] =='7'||chars[i] =='8'||chars[i]=='9'){
                preValue += chars[i];
                System.out.println(preValue);
            }
//            是运算符号
            if (s.isEmpty()) {
//                栈空就进栈
                s.add(chars[i]);
            }
            if (chars[i] == ')') {
//                弹出栈顶元素并输出
                char cur = s.pop();
                preValue += cur;
                System.out.println(preValue);
            }
        }
    }
}
