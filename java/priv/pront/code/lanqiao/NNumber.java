package priv.pront.code.lanqiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-10-18 13:24
 */
public class NNumber {

    public static int nNumberValue(int n){
        if (n <= 0) {
            return 0;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(1, 0);
        indexMap.put(2, 1);
        return process(indexMap, n);
    }

    public static int process(Map<Integer, Integer> indexMap, int n) {
        for (int i = 3; i <= n; i++) {
            indexMap.put(i, indexMap.get(i - 1) + indexMap.get(i - 2));
        }
        return indexMap.get(n);
    }

    public static void main(String[] args) {
        int i = nNumberValue(5);
        System.out.println(i);

    }
}
