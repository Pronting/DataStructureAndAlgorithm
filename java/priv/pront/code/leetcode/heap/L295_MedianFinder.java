package priv.pront.code.leetcode.heap;

import java.util.PriorityQueue;

public class L295_MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public L295_MedianFinder() {

        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        minHeap.add(num);
        if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()){
            maxHeap.add(minHeap.poll());
        }
        if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
}
