package priv.pront.code.od;

import java.util.Scanner;

/**
 * 题目描述
 * 公司用一个字符串来表示员工的出勤信息
 *
 * absent：缺勤
 * late：迟到
 * leaveearly：早退
 * present：正常上班
 * 现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下：
 *
 * 缺勤不超过一次；
 * 没有连续的迟到/早退；
 * 任意连续7次考勤，缺勤/迟到/早退不超过3次。
 * 输入描述
 * 用户的考勤数据字符串
 *
 * 记录条数 >= 1；
 * 输入字符串长度 < 10000；
 * 不存在非法输入；
 * 如：
 *
 * 2
 * present
 * present absent present present leaveearly present absent
 *
 * 输出描述
 * 根据考勤数据字符串，如果能得到考勤奖，输出”true”；否则输出”false”，
 * 对于输入示例的结果应为：
 *
 * true false
 */
public class E2024_考勤信息 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0){
            String[] s = sc.nextLine().split(" ");
            int len = s.length;
            int absentCount = 0;
            int lateRate = 0;
            int leaveeearlyRate = 0;
            int l = 0, r = 0;
            int inValidCount = 0;
            while(r < len){
                String cur = s[r];
                if(cur.equals("absent")){
                    inValidCount++;
                    absentCount++;
                }
                if(cur.equals("late")) {
                    inValidCount++;
                    lateRate++;
                } else {
                    lateRate = Math.max(0, lateRate - 1);
                }
                if(cur.equals("leaveearly")) {
                    inValidCount++;
                    leaveeearlyRate++;
                } else{
                    leaveeearlyRate = Math.max(0, leaveeearlyRate - 1);
                }

                if(absentCount > 1 || lateRate > 1 || leaveeearlyRate > 1 ){
                    System.out.println(false);
                    return;
                }
                if(r - l + 1 == 7){
                    if(inValidCount > 3){
                        System.out.println(false);
                        return;
                    }
                    String strl = s[l];
                    if(strl.equals("absent") || strl.equals("late") || strl.equals("leaveearly")) inValidCount--;
                    l++;
                }
                r++;
            }
            System.out.println(true);
        }
    }
}
