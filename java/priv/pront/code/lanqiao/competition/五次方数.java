package priv.pront.code.lanqiao.competition;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-22 15:22
 */
public class 五次方数 {

    public static void main(String[] args) {
        //找出范围内符合条件的五次方数并输出
        for (int i=0;i<354294;i++){
            if(five(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean five(int n){
        int m=n;
        int sum=0;//存放结果
        while (m!=0){
            sum+=(int)Math.pow(m%10,5);//每一位数的5次方相加
            m=m/10;//向前一位
        }
        if (sum==n){
            return true;
        }else {
            return false;
        }
    }
}
