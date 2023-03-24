package priv.pront.code.lanqiao.competition.course;

public class 格点 {
//15698
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2021; i++) {
            for (int j = 1; j <= 2021; j++) {
                if(i * j <= 2021){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
