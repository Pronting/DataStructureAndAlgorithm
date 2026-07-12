package priv.pront.code.od;

import java.util.*;

public class E2024_执行任务赚积分 {

    static class Info{
        int time;
        int val;
        public Info(int time, int val){
            this.time = time;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();
        List<Info> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Info(sc.nextInt(), sc.nextInt()));
        }
        list.sort((a, b) -> a.time - b.time);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Info info : list) {
            heap.offer(info.val);
            int limit = Math.min(total, info.time);
            if (heap.size() > limit) {
                heap.poll();
            }
        }
        long ans = 0;
        while (!heap.isEmpty()) {
            ans += heap.poll();
        }
        System.out.println(ans);
    }
}
