package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 12:23
 */
public class L17_LetterCombinations {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 初始对应所有的数字，对应2-9
        String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits,numString,0);
        return res;
    }

    //  每次迭代获取一个字符串，所以回设计大量的字符串拼接，这里使用高效的StringBuilder
    StringBuilder temp = new StringBuilder();

    public void backtracking(String digits,String[] numString, int index){
        if("".equals(digits)){
            return;
        }
        if(index == digits.length()){
            res.add(temp.toString());
            return;
        }
        String str = numString[digits.charAt(index) -'0'];
        for(int i = 0;i < str.length();i++){
            temp.append(str.charAt(i));
            backtracking(digits,numString,index+1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }
}
