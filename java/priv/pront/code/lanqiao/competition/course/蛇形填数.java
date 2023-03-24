package priv.pront.code.lanqiao.competition.course;

public class 蛇形填数 {
// 761
    public static void main(String[] args) {
        int curIndex = 0;
        int k = 0;
        for (int i = 0; i < 39; i++) {
            k = i + 1;
            for (int j = 0; j < k; j++) {
                curIndex += 1;
            }
        }
        System.out.println(curIndex - (k / 2));
    }
}
