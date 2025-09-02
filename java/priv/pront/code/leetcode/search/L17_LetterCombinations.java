package priv.pront.code.leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class L17_LetterCombinations {

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits, numString, 0);
        return res;
    }

    StringBuilder sb = new StringBuilder();
    private void dfs(String digits, String[] str, int idx){
        if("".equals(digits)) return;
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(idx);
        String cur = str[c - '0'];
        for(int i = 0; i < cur.length(); i++){
            sb.append(cur.charAt(i));
            dfs(digits, str, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
