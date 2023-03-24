package priv.pront.code.lanqiao.competition.course;

import java.util.Calendar;
//  8879
public class 跑步锻炼 {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int count = 0;
        calendar.set(Calendar.YEAR, 2000);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        while (true) {
            if (calendar.get(Calendar.YEAR) == 2020 && calendar.get(Calendar.MONTH) == 9 && calendar.get(Calendar.DAY_OF_MONTH) == 2) {
                break;
            }
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                count += 2;
            }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
                count += 2;
            }else if(calendar.get(Calendar.DAY_OF_MONTH) == 1){
                count += 2;
            }else{
                count += 1;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(count);
    }
}
