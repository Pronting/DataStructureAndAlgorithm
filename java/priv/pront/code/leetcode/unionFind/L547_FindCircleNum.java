package priv.pront.code.leetcode.unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-07 17:16
 */
public class L547_FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<Integer> provinces = new ArrayList<>();
        for(int i = 0; i< n; i++){
            provinces.add(i);
        }
        UnionFindSetForList<Integer> unionFind = new UnionFindSetForList<>(provinces);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.sizeMap.size();
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new L547_FindCircleNum().findCircleNum(isConnected));
    }

}
