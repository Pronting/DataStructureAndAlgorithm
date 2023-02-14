package priv.pront.code.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-14 13:57
 */
public class L506_FindRelativeRanks {

    public static class RelativeRanksInfo{
        public int index;
        public int value;
        public String res;

        public RelativeRanksInfo(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public RelativeRanksInfo(String res) {
            this.res = res;
        }
    }

    public static  class RelativeComparator implements Comparator<RelativeRanksInfo> {

        @Override
        public int compare(RelativeRanksInfo o1, RelativeRanksInfo o2) {
            return o1.index - o2.index;
        }
    }

    public static class ValueComparator implements Comparator<RelativeRanksInfo>{
        @Override
        public int compare(RelativeRanksInfo o1, RelativeRanksInfo o2) {
            return o2.value - o1.value;
        }
    }


    public static String[] findRelativeRanks(int[] score) {
        String[] str = new String[score.length];
        PriorityQueue<RelativeRanksInfo> sortHeap = new PriorityQueue<>(new ValueComparator());
        PriorityQueue<RelativeRanksInfo> heap = new PriorityQueue<>(new RelativeComparator());
//        排序
        for (int i = 0; i < score.length; i++) {
            sortHeap.add(new RelativeRanksInfo(i, score[i]));
        }

        RelativeRanksInfo first = sortHeap.poll();
        first.res = "Gold Medal";
        heap.add(first);
        first = sortHeap.poll();
        first.res = "Silver Medal";
        heap.add(first);
        first = sortHeap.poll();
        first.res = "Bronze Medal";
        heap.add(first);
        int value = 4;

        while(!sortHeap.isEmpty()){
            RelativeRanksInfo cur = sortHeap.poll();
            cur.res = value++ + "";
            heap.add(cur);
        }

        for (int i = 0; i < score.length; i++) {
            str[i] = heap.poll().res;
        }

        return str;

    }

    public static void main(String[] args) {
        int[] scores = {5, 4, 3, 2, 1};
        for (String relativeRank : findRelativeRanks(scores)) {
            System.out.print(relativeRank + " ");

        }
    }
}
