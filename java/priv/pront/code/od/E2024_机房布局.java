package priv.pront.code.od;

import java.util.Scanner;

public class E2024_机房布局 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        int n = arr.length;

        boolean[] covered = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // 只处理未覆盖的 M
            if (arr[i] == 'M' && !covered[i]) {

                boolean placed = false;

                /*
                 * ===== 贪心策略 =====
                 * 优先在 i+1 放电箱（如果是 I）
                 */
                if (i + 1 < n && arr[i + 1] == 'I') {
                    place(arr, covered, i + 1);
                    ans++;
                    placed = true;
                }

                /*
                 * 否则尝试 i-1
                 */
                else if (i - 1 >= 0 && arr[i - 1] == 'I') {
                    place(arr, covered, i - 1);
                    ans++;
                    placed = true;
                }

                /*
                 * 两边都不能放 → 无解
                 */
                if (!placed) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }

    /*
     * 在 pos 放电箱，覆盖 pos-1 / pos / pos+1 的 M
     */
    private static void place(char[] arr, boolean[] covered, int pos) {
        for (int j = pos - 1; j <= pos + 1; j++) {
            if (j >= 0 && j < arr.length && arr[j] == 'M') {
                covered[j] = true;
            }
        }
    }
}
