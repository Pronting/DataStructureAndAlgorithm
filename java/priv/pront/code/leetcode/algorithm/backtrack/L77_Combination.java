package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 18:08
 */
public class L77_Combination {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,0);
        return res;
    }

    public void backtracking(int n, int k , int startIndex){
        if(path.size() == k){
            res.add(new ArrayList<>(path));
        }
        for(int i = 0;i < n ; i ++){
            path.add(i);
            backtracking( n, k ,++startIndex);
            path.remove(path.size() - 1);
        }
    }
}
