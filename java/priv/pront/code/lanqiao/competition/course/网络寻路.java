package priv.pront.code.lanqiao.competition.course;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 网络寻路 {

    static ArrayList<Integer>[] G = new ArrayList[10001];//泛型数组,ArrayList 本身可以看出一个数组,相当于一个二维数组,每一个数组存储该点的相邻节点
    static int ans = 0;
    static boolean visited[] = new boolean[100001];//该数组表示该点是否已经访问过了

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));//定义一个缓冲流
        String[] c = bfr.readLine().split(" ");//读取一个文本行,并去掉其中的空格,并将其转到string数组中,便于后续操作好提取
        int n = Integer.parseInt(c[0]);//提取第一位,即输入的n
        int m = Integer.parseInt(c[1]);//提取第二位,即输入的m
        int u, v;
        for (int i = 0; i < G.length; i++) {
            G[i] = new ArrayList();//初始化泛型数组,不做此步,会报错
        }
        for (int i = 0; i < m; i++) {
            c = bfr.readLine().split(" ");
            u = Integer.parseInt(c[0]);
            v = Integer.parseInt(c[1]);
            G[u - 1].add(v - 1);//减一是因为题中给出点是从1开始的,而数组是从0开始的
            G[v - 1].add(u - 1);//u和v相连,则v和u也相连

        }
        for (int i = 0; i < n; i++) {
            visited[i] = true;//标记此点已经访问过了
            dfs(i, i, 0);
            visited[i] = false;//回溯,找其他与该点相连的点
        }
        System.out.println(ans);

    }

    static void dfs(int u, int start, int num) {
        int size = G[u].size();//得到与u相连的点的个数,size方法返回的是此列表中的元素个数,并不是此列表的大小
        if (num > 2) {//如果num大于2,继续搜索已经没有意义
            return;
        }
        for (int i = 0; i < size; i++) {
            int v = G[u].get(i);//得到与u相连的点
            if (num == 2 && ((v == start) || (visited[v] == false))) {//如果长度为2,该点是起点,满足,或者该点还没有被访问过,也满足
                ans++;
                continue;//退出该次循环,继续下次循环
            }
            if (visited[v] == false) {//如果该点没有被访问过,继续往下搜索
                visited[v] = true;//先将此点标记为已经访问
                dfs(v, start, num + 1);
                visited[v] = false;//回溯,回溯,找其他与该点相连的点,此处的回溯与main方法中的回溯并不重复,可看成是一个双层循环
            }
        }
    }
}
