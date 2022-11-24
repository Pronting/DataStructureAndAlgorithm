package priv.pront.code.lanqiao.LG;

import java.util.Scanner;

/**
 * @Description: 车厢重做
 * @Author: pront
 * @Time:2022-11-24 20:24
 */
public class P1116 {

    public static void main(String []args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();   //车箱数
        int cnt=0;                  //统计所需排列次数
        int []a=new int [n];         //存储初始车厢顺序
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();    //输入车厢顺序
        }
        for(int j=n;j>=1;j--)        //控制每轮要比较的个数
        {
            for(int i=0;i<j-1;i++)
            {
                if(a[i]<a[i+1])
                    continue;         //继续循环
                else                  //交换
                {
                    int temp=a[i+1];
                    a[i+1]=a[i];
                    a[i]=temp;
                    cnt++;            //计数
                }
            }
        }
        System.out.println(cnt);
    }
}
