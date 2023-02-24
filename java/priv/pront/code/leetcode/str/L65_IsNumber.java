package priv.pront.code.leetcode.str;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-24 11:32
 */
public class L65_IsNumber {

    static final char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final char[] other = {'.', '-', '+', 'e', 'E'};


    public static boolean isNumber(String s) {
        Set<Character> containsStr = new HashSet<>();
        Set<Character> numberSet = new HashSet<>();
        Set<Character> otherSet = new HashSet<>();

        for (int i = 0; i < number.length; i++) {
            containsStr.add(number[i]);
            numberSet.add(number[i]);
        }
        for (int i = 0; i < other.length; i++) {
            containsStr.add(other[i]);
            otherSet.add(other[i]);
        }

        for (int i = 0; i < s.length(); i++) {
            if (!containsStr.contains(s.charAt(i))) {
                return false;
            }
        }

        boolean dian = true;
        boolean jia = true;
        for(int i = 0; i< s.length(); i++){

            // e or E
            // e or E
            if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && (i + 1 < s.length() && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+' || numberSet.contains(s.charAt(i + 1)))) && (i - 1 >=0 && numberSet.contains(s.charAt(i - 1)))){
                continue;
            }else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && (!(i + 1 < s.length() && (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+' || numberSet.contains(s.charAt(i + 1)))) || !(i - 1 >=0 && numberSet.contains(s.charAt(i - 1))))){
                return false;
            }
            // .
            if(dian && (s.charAt(i) == '.' && ((i - 1 >= 0 && numberSet.contains(s.charAt(i - 1))) ||(i + 1 < s.length() && numberSet.contains(s.charAt(i + 1)))))){
                for(int curIndex = i + 1; curIndex < s.length(); curIndex++){
                    if(s.charAt(curIndex) == '.'){
                        return false;
                    }
                }
                dian = false;
                continue;
            }else if(dian && (s.charAt(i) == '.' && !((i - 1 >= 0 && numberSet.contains(s.charAt(i - 1))) ||(i + 1 < s.length() && numberSet.contains(s.charAt(i + 1)))))){

                return false;
            }
            // + - 去重
            if((s.charAt(i) == '+' || s.charAt(i) == '-') && jia == false){
                return false;
            }

            // + - 前不能有数字
            if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i - 1 >= 0 && numberSet.contains(s.charAt(i-1)))){
                return false;
            }
            // + - 后必须有数字
            if((s.charAt(i) == '+' || s.charAt(i) == '-') && !(((i + 1 < s.length()) && (numberSet.contains(s.charAt(i + 1)))) || (i + 1 <s.length() && s.charAt(i + 1) == '.'))){
                return false;
            }
            if(s.charAt(i) == '+'  || s.charAt(i) == '-'){
                jia = false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(isNumber("8.+"));
    }
}
