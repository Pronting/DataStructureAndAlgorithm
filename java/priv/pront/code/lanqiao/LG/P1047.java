package priv.pront.code.lanqiao.LG;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-24 18:23
 */
public class P1047 {

    private static Map<Integer, Integer> regionEndMap = new HashMap<>();
    private static Map<Integer, Integer> regionBeginMap = new HashMap<>();
    private static Map<Integer, Integer> otherMap = new HashMap<>();


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int begin = scan.nextInt();
            int end = scan.nextInt();
            getRegion(begin, end);
        }
        int end = 0;
        int begin = 0;
        for (Map.Entry<Integer, Integer> cur : regionEndMap.entrySet()) {
            end = cur.getValue();
        }
        for (Map.Entry<Integer, Integer> cur : regionBeginMap.entrySet()) {
            begin = cur.getValue();
        }
        for (int i = 0; i <m; i++) {

        }
        System.out.println(begin + 1 + l - end + 1);
    }

    private static void getRegion(int begin, int end) {
        if (regionEndMap.isEmpty()) {
            regionEndMap.put(begin, end);
        } else {
            for (Map.Entry<Integer, Integer> cur : regionEndMap.entrySet()) {
                int endValue = cur.getValue();
                if (endValue < end && begin >= endValue) {
                    cur.setValue(end);
                } else {
                    if (otherMap.isEmpty()) {
                        otherMap.put(begin, end);
                    }else{
                        if(otherMap.containsKey(begin) && otherMap.get(begin) < end){
                            otherMap.put(begin, end);
                        }
                        for (Map.Entry<Integer, Integer> cc : otherMap.entrySet()) {
//                            TODO
                            cc.getKey();
                        }
                    }
                }
            }
        }
        if (regionBeginMap.isEmpty()) {
            regionBeginMap.put(end, begin);
        } else {
            for (Map.Entry<Integer, Integer> cur : regionBeginMap.entrySet()) {
                int beginValue = cur.getValue();
                if (beginValue > begin && end <= beginValue) {
                    cur.setValue(begin);
                }
            }
        }
    }
}
