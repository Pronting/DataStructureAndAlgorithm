package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100。
 *
 * 他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。
 *
 * 请问最后剩余的人在原先的编号为多少？
 *
 * 输入描述
 * 输入一个整数参数 M
 *
 * 输出描述
 * 如果输入参数M小于等于1或者大于等于100，输出“ERROR!”；
 *
 * 否则按照原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
 */
public class E2024_YSF_loop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        if(M <= 1 || M > 100){
            System.out.println("ERROR");
            return;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 100; i++) list.add(i);
        int index = 0;
        int count = 1;
        while(list.size() > M){
            if(count == M){
                list.remove(index);
                count = 1;
                index = index % list.size();
            }else{
                index = (index + 1) % list.size();
                count++;
            }
        }

        // 输出结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
    }
}
