package priv.pront.code.od;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 存在一个m×n的二维数组，其成员取值范围为0或1。
 *
 * 其中值为1的成员具备扩散性，每经过1S，将上下左右值为0的成员同化为1。
 *
 * 二维数组的成员初始值都为0，将第[i,j]和[k,l]两个个位置上元素修改成1后，求矩阵的所有元素变为1需要多长时间。
 *
 * 输入描述
 * 输入数据中的前2个数字表示这是一个m×n的矩阵，m和n不会超过1024大小；
 *
 * 中间两个数字表示一个初始扩散点位置为i,j；
 *
 * 最后2个数字表示另一个扩散点位置为k,l。
 *
 * 输出描述
 * 输出矩阵的所有元素变为1所需要秒数。
 */
public class E2024_矩阵扩散 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int i = Integer.parseInt(split[2]);
        int j = Integer.parseInt(split[3]);
        int k = Integer.parseInt(split[4]);
        int l = Integer.parseInt(split[5]);
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] matrix = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        queue.add(new int[]{k, l});
        matrix[i][j] = matrix[k][l] = 1;
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int t = 0; t < size; t++){
                int[] poll = queue.poll();
                for(int r = 0; r < 4; r++){
                    int nx = poll[0] + dx[r];
                    int ny = poll[1] + dy[r];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == 1) continue;
                    queue.add(new int[]{nx, ny});
                    matrix[nx][ny] = 1;
                }
            }
        }
        System.out.println(time - 1);
    }
}
