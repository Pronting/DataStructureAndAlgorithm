package priv.pront.code.lanqiao.competition.province2021;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-14 10:13
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ans用于存放称出的不同重量
        Set<Integer> ans = new HashSet<Integer>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            //由于set在遍历的过程中不能添加元素，因此用另外一个set来存放该砝码称出的重量
            Set<Integer> temp = new HashSet<Integer>();
            Iterator<Integer> it = ans.iterator();
            while (it.hasNext()) {
                int m = it.next();
                temp.add(m + t);
                temp.add(Math.abs(m - t));
            }
            //再全部加入到ans集合中
            ans.addAll(temp);
            //砝码必定可以称出自身重量
            ans.add(t);
        }
        ans.remove(0);
        System.out.println(ans.size());
    }
}
