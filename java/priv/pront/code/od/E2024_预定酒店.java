package priv.pront.code.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 放暑假了，小明决定到某旅游景点游玩，他在网上搜索到了各种价位的酒店（长度为n的数组A），他的心理价位是x元，请帮他筛选出k个最接近x元的酒店（n>=k>0）,并由低到高打印酒店的价格。
 *
 * 输入描述
 * 第一行：n, k, x
 * 第二行：A[0] A[1] A[2]…A[n-1]
 *
 * 输出描述
 * 从低到高打印筛选出的酒店价格
 */
public class E2024_预定酒店 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(sc.nextInt());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer diffA = Math.abs(o1 - t);
                Integer diffB = Math.abs(o2 - t);
                if(diffA == diffB) return Integer.compare(o1, o2);
                else{
                    return Integer.compare(diffA, diffB);
                }
            }
        });


        for(int i = 0; i < k; i++){
            if(i != 0) System.out.print(" ");
            System.out.print(list.get(i));
        }
    }
}
