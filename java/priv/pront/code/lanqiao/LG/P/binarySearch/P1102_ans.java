package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 】、
 * @Author: pront
 * @Time:2023-01-17 18:01
 */
public class P1102_ans {

    //成员变量比局部变量占用内存更小
    static int[] a;
    static long ans=0;
    static int t = 0;//引入变量t,记录键（数字）的次数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        //建立一个数字到出现次数的映射 map<num,times>
        Map<Integer,Integer> m=new HashMap<Integer, Integer>();
        a=new int[n];
        for(int i=0;i<n;i++) {
            a[i]=in.nextInt();
            if(m.get(a[i])==null)t=0;//必须判断值是否为空，否则报错
            else t=m.get(a[i]);
            m.put(a[i],++t);
        }
        //将查找A、B满足A-B=C，转换成只需查找A满足A=B+C
        for(int i=0;i<n;i++) {
            if(m.get(a[i]+c)!=null)//必须判断值是否为空，否则报错
                ans+=m.get(a[i]+c);
        }
        System.out.println(ans);
    }

}
