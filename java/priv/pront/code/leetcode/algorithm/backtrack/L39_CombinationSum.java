package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-09 11:45
 */
public class L39_CombinationSum {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int startIndex,int sum){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i< candidates.length && sum + candidates[i] <= target;i++){
            // 添加自己本身
            if(sum + candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            backtracking(candidates,target,i,sum + candidates[i]);
            path.remove(path.size() - 1);

        }
    }
}
