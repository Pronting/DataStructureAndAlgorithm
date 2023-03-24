package priv.pront.code.lanqiao.competition.course;

public class 门牌制作 {
//  624
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 1; i <= 2020; i++) {
            String j = i + "";
            for (int k = 0; k < j.length(); k++) {
                arr[j.charAt(k) - '0']++;
            }
        }
        System.out.println(arr[2]);

    }
}
