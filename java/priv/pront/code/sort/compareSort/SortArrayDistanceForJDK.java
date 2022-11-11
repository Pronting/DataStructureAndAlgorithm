package priv.pront.code.sort.compareSort;

import java.util.PriorityQueue;

//FOR TEST
public class SortArrayDistanceForJDK {
    public static void main(String[]args){
//        系统提供的堆排序(默认小跟堆)
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.add(8);
        heap.add(4);
        heap.add(6);
        heap.add(8);
        heap.add(9);
        heap.add(2);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
