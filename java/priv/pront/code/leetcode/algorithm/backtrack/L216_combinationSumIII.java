package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 22:07
 */
public class L216_combinationSumIII {

    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();


    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    public static void backtracking(int numSize, int target, int startIndex) {
        int curTarget = 0;
        for (Integer cur : path) {
            curTarget += cur;
        }
        if (curTarget == target && path.size() == numSize) {
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i <= target; i++) {
            if (path.size() >= numSize) {
                return;
            } else {
                path.add(i);
                backtracking(numSize, target, i + 1);
                path.remove(path.size() - 1);
            }
        }

    }

//    进行了剪枝优化后的代码
    public void backtracking2(int numSize,int target,int startIndex,int sum){
        // 剪枝
        if(sum > target){
            return;
        }
        if(path.size() == numSize){
            if(sum == target){
                res.add(new ArrayList<>(path));
            }
            return;
        }

//      剪枝
        for (int i = startIndex; i <= 9 - (numSize - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking2(numSize, target, i + 1,sum);
            path.remove(path.size() - 1);
            sum -= i ;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }
}
