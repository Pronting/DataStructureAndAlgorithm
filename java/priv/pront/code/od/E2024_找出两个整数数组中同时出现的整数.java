package priv.pront.code.od;

import java.util.*;

/**
 * 现有两个整数数组，需要你找出两个数组中同时出现的整数，并按照如下要求输出:有同时出现的整数时，
 * 先按照同时出现次数（整数在两个数组中都出现并目出现次数较少的那个）进行归类，然后按照出现次数从小到大依次按行输出。 没有同时出现的整数时，输出NULL.
 */
public class E2024_找出两个整数数组中同时出现的整数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a1 = sc.nextLine().split(",");
        String[] a2 = sc.nextLine().split(",");
        int[] arr1 = new int[a1.length];
        int[] arr2 = new int[a2.length];
        for (int i = 0; i < arr1.length; i++) arr1[i] = Integer.parseInt(a1[i]);
        for (int i = 0; i < arr2.length; i++) arr2[i] = Integer.parseInt(a2[i]);
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int[] cnt1 = new int[400];
        int[] cnt2 = new int[400];
        for (int i : arr1) cnt1[i + 200]++;
        for (int i : arr2) cnt2[i + 200]++;

        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            if(set.contains(i)) continue;
            int idx = i + 200;
            int cnt = Math.min(cnt1[idx], cnt2[idx]);
            if(cnt == 0) continue;
            if(map.containsKey(cnt)){
                map.get(cnt).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cnt, list);
            }
            set.add(i);
        }
        if (map.isEmpty()) {
            System.out.println("NULL");
        }
        map.forEach((k, v) ->{
            System.out.print(k + ":");
            Collections.sort(v);
            for(int i = 0; i < v.size(); i++){
                if(i != 0) System.out.print(",");
                System.out.print(v.get(i));
            }
            System.out.println();
        });


    }
}
