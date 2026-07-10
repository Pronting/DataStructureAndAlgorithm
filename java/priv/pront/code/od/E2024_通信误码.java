package priv.pront.code.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 信号传播过程中会出现一些误码，不同的数字表示不同的误码ID，取值范围为1 ~ 65535，用一个数组记录误码出现的情况，每个误码出现的次数代表误码频度，请找出记录中包含频度最高误码的最小子数组长度。
 *
 * 输入描述
 * 误码总数目：取值范围为0~255，取值为 0 表示没有误码的情况。
 * 误码出现频率数组：误码ID范围为1 ~ 65535，数组长度为1 ~ 1000
 *
 *
 * 输出描述
 * 包含频率最高的误码最小子数组长度
 */
public class E2024_通信误码 {

    static class Info{
        int count;
        int first;
        int last;

        public Info(int idx){
            this.count = 1;
            this.first = idx;
            this.last = idx;
        }
    }

    static Map<Integer, Info> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new Info(i));
            }else{
                map.get(arr[i]).count++;
                map.get(arr[i]).last = i;
            }
        }
        int maxCount = 0;
        for (Info value : map.values()) {
            maxCount = Math.max(maxCount, value.count);
        }

        int len = Integer.MAX_VALUE;
        for (Info value : map.values()) {
            if (value.count == maxCount) {
                len = Math.min(len, value.last - value.first + 1);
            }
        }
        System.out.println(len);
    }
}
