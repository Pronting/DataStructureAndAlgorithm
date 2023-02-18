package priv.pront.code.leetcode.algorithm.other;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-17 13:49
 */
public class L20_ParenthesIsVaild {

    public static boolean isValid(String s) {
        if(s.length() == 1){
            return false;
        }
        int xiao = 0;
        int zhong = 0;
        int da = 0;
        for(int i = 0; i< s.length(); i++){
            if(xiao < 0 || zhong < 0 || da < 0){
                return false;
            }
            if(s.charAt(i) == '('){
                xiao++;
            }else if(s.charAt(i) == '['){
                zhong++;
            }else if(s.charAt(i) == '{'){
                da++;
            }else if(s.charAt(i) == ')'){
                xiao--;
            }else if(s.charAt(i) ==']'){
                zhong--;
            }else if(s.charAt(i) =='}'){
                da--;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }
}
