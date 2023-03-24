package priv.pront.code.lanqiao.competition.course;

public class 城邦 {
// 36451
    public static void main(String[] args) {

        int sum = 0;
        int count = 0;
        while (count != 405) {
            for (int i = 1; i <= 9; i++) {
                if (i != 9) {
                    sum += i + i + 1;
                } else {
                    sum += i + 1;
                }
            }
            count++;
        }
        System.out.println(sum + 1);
    }
}
