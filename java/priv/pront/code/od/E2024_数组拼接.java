package priv.pront.code.od;

import java.util.*;

public class E2024_数组拼接 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        List<Queue<Integer>> queues = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] s = sc.nextLine().split(",");
            Queue<Integer> queue = new LinkedList<>();
            for (String string : s) {
                queue.add(Integer.parseInt(string));
            }
            queues.add(queue);
        }
        int remain = n;
        List<Integer> ans = new ArrayList<>();
        while(remain > 0){
            for(int i = 0; i < n; i++){
                Queue<Integer> q = queues.get(i);
                if(q.isEmpty()) continue;
                int cnt = k;
                while(cnt > 0 && !q.isEmpty()){
                    cnt--;
                    ans.add(q.poll());
                }
                if(q.isEmpty()) remain --;
            }
        }
        for(int i = 0; i < ans.size(); i++){
            if(i != 0) System.out.print(",");
            System.out.print(ans.get(i));
        }
    }
}
