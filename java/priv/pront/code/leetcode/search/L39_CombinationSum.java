package priv.pront.code.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39_CombinationSum {

    List<Integer> path = new ArrayList<>();

    List<List<Integer>> res = new ArrayList();

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
            if(sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(candidates,target,i,sum + candidates[i]);
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        L39_CombinationSum combinationSum = new L39_CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
