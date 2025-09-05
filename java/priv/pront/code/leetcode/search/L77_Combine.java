package priv.pront.code.leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class L77_Combine {


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 0);
        return ans;
    }

    private void dfs(int n, int k, int idx) {
        if (path.size() == k) {
            ArrayList<Integer> integers = new ArrayList<>(path);
            ans.add(integers);
            return;
        }
        for (int i = idx; i < n - (k - path.size()) + 1; i++) {
            path.add(i + 1);
            dfs(n, k, i + 1);
            path.remove(path.get(path.size() - 1));
        }
    }
}
