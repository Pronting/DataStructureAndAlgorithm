package priv.pront.code;

import java.util.*;
public class main {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> ind = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] relate : prerequisites) {
            int cur = relate[1];
            int next = relate[0];
            ind.put(next, ind.getOrDefault(next, 0) + 1);
            if(map.containsKey(cur)){
                map.put(cur, new ArrayList<>());
            }
            map.put(cur, map.get(cur)).add(next);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int key : ind.keySet()){
            if(ind.get(key) == 0) queue.offer(key);
        }

        while(!queue.isEmpty()){
            int key = queue.poll();
            if(!map.containsKey(key)) continue;
            List<Integer> nexts = map.get(key);
            for(int k : nexts){
                ind.put(k, ind.get(k) - 1);
                if(ind.get(k) == 0) queue.offer(k);
            }
        }
        for(int k : ind.keySet()){
            if(ind.get(k) != 0) return false;
        }
        return true;
    }
}
