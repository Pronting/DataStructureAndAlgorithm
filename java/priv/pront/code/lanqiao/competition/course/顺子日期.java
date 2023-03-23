package priv.pront.code.lanqiao.competition.course;

import java.util.Calendar;

public class 顺子日期 {

//     012 123
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int count = 0;
        while (calendar.get(Calendar.YEAR) != 2023) {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println(year + "年" + month + "月" + day + "日");
            String smonth = month + "";
            String sDay = day + "";
            if (smonth.length() == 2 && smonth.charAt(0) == '1' && smonth.charAt(0) == '2' && sDay.charAt(0) == '3') {
                count++;
            }else if (smonth.length() == 1 && sDay.length() == 2 && smonth.charAt(0) == '1' && sDay.charAt(0) == '2' && sDay.charAt(1) == '3') {
                count++;
            }else if (smonth.length() == 1 && smonth.charAt(0) == '1' && sDay.charAt(0) == '2') {
                count++;
            }else if (smonth.length() == 2 && sDay.length() == 2 && smonth.charAt(1) == '0' && sDay.charAt(0) == '1' && sDay.charAt(1) == '2') {
                count++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
    }
}
