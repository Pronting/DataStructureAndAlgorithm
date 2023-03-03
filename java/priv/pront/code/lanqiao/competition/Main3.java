package priv.pront.code.lanqiao.competition;

/**
 * @Description: 　对于一个日期，我们可以计算出年份的各个数位上的数字之和，
 * 也可以分别计算月和日的各位数字之和。请问从 1900 年 1 月 1 日至 9999 年 12 月 31 日
 * ，总共有多少天，年份的数位数字之和等于月的数位数字之和加日的数位数字之和。
 * 　　例如，2022年11月13日满足要求，因为 2+0+2+2=(1+1)+(1+3) 。
 * 　　请提交满足条件的日期的总数量。
 * @Author: pront
 * @Time:2023-03-03 09:33
 */
public class Main3 {

    public static void main(String[] args) {
        int count = 0;
        for(int i = 1900 ; i <= 9999;i++ ){
            int year = i / 1000 + i % 1000 / 100 + i % 1000 % 100 / 10 + i % 1000 % 100 % 10;
            for (int j = 1; j <= 12 ; j++) {
                int month;
                String monthLength = j + "";
                if("1".equals(monthLength)){
                    month = j;
                }else{
                    month =j /10 + j % 10;
                }
                for(int k = 1 ; k <= 31;k ++){
                    int day;
                    String dayLength = k + "";
                    if ("1".equals(dayLength)) {
                        day = k;
                    }else{
                        day = k / 10 + k % 10;
                    }
                    if(year == month  + day){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
