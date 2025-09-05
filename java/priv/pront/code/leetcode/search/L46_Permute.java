package priv.pront.code.leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class L46_Permute {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] st = new boolean[nums.length];
        dfs(nums, st);
        return ans;
    }

    public void dfs(int[] nums, boolean[] st){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!st[i]){
                st[i] = true;
                path.add(nums[i]);
                dfs(nums, st);
                st[i] = false;
                path.remove(path.get(path.size() - 1));
            }
        }
    }
}
