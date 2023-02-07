package priv.pront.code.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-07 18:54
 */
public class P22_GenerateParenthesis {

    List<String> res = new ArrayList<>();

//    暴力解法 2ms
    public List<String> generateParenthesis1(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n] , combinations , 0);
        return combinations;
    }

    public void generateAll(char[] current , List<String> list , int pos){
        if(pos == current.length){
            if(valid(current)){
                list.add(new String(current));
            }
        }else{
            current[pos] = '(';
            generateAll(current , list , pos+1);
            current[pos] = ')';
            generateAll(current , list , pos+1);
        }
    }

    public boolean valid(char[] chs){
        int status = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ')' && --status < 0) {
                return false;
            }
            if (chs[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }



//  回溯 1ms
    public List<String> generateParenthesis2(int n) {
        if (n <= 0){
            return null;
        }
        def("", 0, 0, n);
        return res;
    }

    public void def(String paths, int left, int right, int n) {
        if (left > n || right > left){
            return;
        }
        if (paths.length() == n * 2) {
            res.add(paths);
            return;
        }
        def(paths + "(", left + 1, right, n);
        def(paths + ")", left, right + 1, n);
    }
}
