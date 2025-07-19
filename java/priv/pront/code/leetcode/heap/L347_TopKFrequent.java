package priv.pront.code.leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;

public class L347_TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] heap = new int[k];
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            list.add(nums[i]);
        }
        list = list.stream().distinct().collect(Collectors.toList());
        for(int i = 0; i < k; i++){
            heap[i] = nums[i];
            heapInsert(heap, i, map);
        }
        for(int i = k; i < nums.length; i++){
            if(map.get(nums[i]) > map.get(heap[0])){
                heap[0] = nums[i];
                heapify(heap, 0, k, map);
            }
        }
        return heap;
    }


    private void heapInsert(int[] heap, int i, Map<Integer, Integer> map){
        while(map.get(heap[(i - 1 ) / 2]) > map.get(heap[i])){
            swap((i - 1) / 2, i, heap);
            i = (i - 1) / 2;
        }
    }

    private void heapify(int[] heap, int i, int size, Map<Integer, Integer> map){
        int l = i * 2 + 1;
        while(l < size){
            int min = l + 1 < size && map.get(heap[l + 1]) < map.get(heap[l]) ? l + 1 : l;
            min = map.get(heap[min]) < map.get(heap[i]) ? min : i;
            if(min == i) break;
            swap(min, i, heap);
            i = min;
            l = i * 2 + 1;
        }
    }

    private void swap(int i, int j, int[] heap){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
