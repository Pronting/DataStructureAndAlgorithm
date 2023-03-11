package priv.pront.code.lanqiao.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-09 17:15
 */
public class Main11 {

    public static void main(String[] args) {
//        优先级缓存暂且使用list存储
        List<Integer> list = new ArrayList<>();

//        订单信息按照时间顺序存储在有序表中
        TreeMap<Integer, Integer> timeOfMai = new TreeMap<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // N 的卖家
        int M = scanner.nextInt();  // M 个订单
        int T = scanner.nextInt();  // 共有T秒
//      卖家存放在数组中,初始状态，各个卖家的优先级默认为0
        int[] arr = new int[N];

//        存放订单
        for (int i = 0; i < M; i++) {
            timeOfMai.put(scanner.nextInt(), scanner.nextInt());
        }

//      遍历订单
        for (int i = 1; i <= T; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] > 0 ){
                    arr[j] -= 1;
                }
//                如果有关于这条时间的订单
                if(timeOfMai.containsKey(i)){
//                    将关联的卖家取出来
                    Integer integer = timeOfMai.get(i);
                    arr[integer] += 3;
                }
                if(arr[j] > 5){
                    list.add(j);
                }
                if(arr[j] < 3){
                    list.remove(j);
                }

            }

        }
//        timeOfMai.forEach((key, value) -> {
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] > 0) {
//                    arr[i] -= 1;
//                }
//            }
//            arr[value - 1] += 3;
//            for(int i = 0; i < arr.length; i++){
//                if (arr[i] > 5 && !list.contains(i)) {
//                    list.add(i);
//                }
//                if(arr[i] < 3 && list.contains(i)){
//                    list.remove(i);
//                }
//            }
//        });

        System.out.println(list.size());

    }

}
