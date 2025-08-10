package priv.pront.code.leetcode.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        for(int i = 0; i < intervals.length; i++){
            int l = intervals[i][0], r = intervals[i][1];
            if(list.isEmpty() || l > list.get(list.size() - 1)[1]){
                list.add(intervals[i]);
            }else{
                int max = Math.max(list.get(list.size() - 1)[1], r);
                list.get(list.size() - 1)[1] = max;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
