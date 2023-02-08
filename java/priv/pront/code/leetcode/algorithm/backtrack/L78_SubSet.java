package priv.pront.code.leetcode.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-08 21:13
 */
public class L78_SubSet {

    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    public static void backtracking(int[]nums,int startIndex){

        res.add(new ArrayList<>(path));

        for(int i = startIndex;i < nums.length;i++){
            // 树中的每一个节点都是答案
            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}
