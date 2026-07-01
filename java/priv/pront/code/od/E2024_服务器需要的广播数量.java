package priv.pront.code.od;

import java.util.Scanner;

/**
 * 服务器连接方式包括直接相连，间接连接。
 *
 * A和B直接连接，B和C直接连接，则A和C间接连接。
 *
 * 直接连接和间接连接都可以发送广播。
 *
 * 给出一个N*N数组，代表N个服务器，
 *
 * matrix[i][j] == 1，
 * 则代表i和j直接连接；不等于 1 时，代表i和j不直接连接。
 *
 * matrix[i][i] == 1，
 *
 * 即自己和自己直接连接。matrix[i][j] == matrix[j][i]。
 *
 * 计算初始需要给几台服务器广播， 才可以使每个服务器都收到广播。
 *
 * 输入描述
 * 输入为N行，每行有N个数字，为0或1，由空格分隔，
 *
 * 构成N*N的数组，N的范围为 1 <= N <= 40
 *
 * 输出描述
 * 输出一个数字，为需要广播的服务器的数量
 */
public class E2024_服务器需要的广播数量 {

    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            matrix[0][i] = Integer.parseInt(s[i]);
        }
        for(int i = 1; i < n; i++){
            s = sc.nextLine().split(" ");
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(matrix[i][j] == 1){
                    union(i, j);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(find(i) == i) ans++;
        }
        System.out.println(ans);

    }

    public static void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if(roota != rootb){
            parent[rootb] = roota;
        }
    }


    public static int find(int son){
        if(parent[son] != son){
            parent[son] = find(parent[son]);
        }
        return parent[son];
    }
}
