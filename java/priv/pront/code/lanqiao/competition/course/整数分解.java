package priv.pront.code.lanqiao.competition.course;

public class 整数分解 {
//691677274345
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 2021; i++) {
            for (int j = 1; j < 2021; j++) {
                for (int k = 1; k < 2021; k++) {
                    for (int l = 1; l < 2021; l++) {
                        for (int m = 1; m < 2021; m++) {
                            if (i + j + k + l + m == 2021) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
