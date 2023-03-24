package priv.pront.code.lanqiao.competition.course;

import java.util.Calendar;

public class 完全日期 {
// 997
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2001);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int count = 0;
        while (true) {
            if (calendar.get(Calendar.YEAR) == 2022 && calendar.get(Calendar.MONTH) == 0 && calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                break;
            }
            String year = calendar.get(Calendar.YEAR) + "";
            String mouth = calendar.get(Calendar.MONTH) + 1 + "";
            String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
            int sum = 0;
            for (int i = year.length() - 1; i >= 0; i--) {
                sum += (year.charAt(i) - '0');
            }
            for (int i = 0; i < mouth.length(); i++) {
                sum += (mouth.charAt(i) - '0');
            }
            for (int i = 0; i < day.length(); i++) {
                sum += (day.charAt(i) - '0');
            }
            double sqrt = Math.sqrt(sum);
            if (sqrt - (int) sqrt == 0) {
                count++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);

        }
        System.out.println(count);

    }
}
