package priv.pront.code.lanqiao.competition;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-17 17:21
 */
public class 第十一届省赛C组_作物杂交 {

    static int N, M, K, T;
    //N表示作物种类总数 (编号1至N)，M表示初始拥有的作物种子类型数量，K表示可以杂交的方案数，T表示目标种子的编号
    static int[] Time;//其中第i个整数表示第i种作物的种植时间 T_i
    static boolean[] Had;//分别表示已拥有的种子类型
    static Map<Integer, int[]> programme;//每行包含 3 个整数 c,{a,b}，表示第 A类作物和第 B类作物杂交可以获得第 C类作物的种子。

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();//初试种类数
        K = scanner.nextInt();
        T = scanner.nextInt();
        Time = new int[N+1];
        for (int i = 1; i < Time.length; i++) {
            Time[i] = scanner.nextInt();//每个作物的种植时间
        }
        Had = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            int temp = scanner.nextInt();//已经拥有的种子
            Had[temp] = true;
        }
        programme = new HashMap<>();
        for (int i = 0; i < K; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            programme.put(c, new int[]{a, b});
        }
        System.out.println(time(T));
    }

    public static int time(int index){
        if (Had[index]){
            return 0;
        }else {
            Had[index] = true;
            //得到a、b种子的时间
            int aTime = time(programme.get(index)[0]);
            int bTime = time(programme.get(index)[1]);
            //从a,b得到目标种子
            int a = Time[programme.get(index)[0]];
            int b = Time[programme.get(index)[1]];
            //将两者相加
            return Math.max(a, b) + Math.max(aTime, bTime);
        }
    }
}
