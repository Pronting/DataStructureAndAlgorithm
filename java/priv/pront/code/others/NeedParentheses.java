package priv.pront.code.others;

/**
 * @Description: 括号问题
 * @Author: pront
 * @Time:2022-11-22 18:21
 */
public class NeedParentheses {

    public static int needParentheses(String str) {
        int count = 0;
        int needSolveRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }else{
                if (count == 0) {
                    needSolveRight++;
                }else{
                    count--;
                }
            }
        }
        return count + needSolveRight;
    }
}
