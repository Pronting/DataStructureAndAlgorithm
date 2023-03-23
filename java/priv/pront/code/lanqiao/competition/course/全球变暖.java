package priv.pront.code.lanqiao.competition.course;

import java.io.*;
import java.util.Stack;

public class 全球变暖 {

    static char[][] arr;
    static int num = 0;
    static void find(int x, int y) {
        arr[x][y] = '0';
        if (arr[x + 1][y] != '.' && arr[x - 1][y] != '.' && arr[x][y + 1] != '.' && arr[x][y - 1] != '.') {
            num--;
            change(x, y);
            return;
        }

        if (arr[x + 1][y] == '#')
            find(x + 1, y);
        if (arr[x - 1][y] == '#')
            find(x - 1, y);
        if (arr[x][y + 1] == '#')
            find(x, y + 1);
        if (arr[x][y - 1] == '#')
            find(x, y - 1);
    }

    static void change(int x, int y) {
        Stack<Integer> stack = new Stack<>();
        stack.add(x);
        stack.add(y);
        while (!stack.isEmpty()) {
            y = stack.pop();
            x = stack.pop();
            arr[x][y] = '.';
            if (arr[x + 1][y] != '.') {
                stack.add(x + 1);
                stack.add(y);
            }
            if (arr[x - 1][y] != '.') {
                stack.add(x - 1);
                stack.add(y);
            }
            if (arr[x][y + 1] != '.') {
                stack.add(x);
                stack.add(y + 1);
            }
            if (arr[x][y - 1] != '.') {
                stack.add(x);
                stack.add(y - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; ++i) {
            arr[i] = br.readLine().toCharArray();
        }
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (arr[i][j] == '#') {
                    num++;
                    find(i, j);
                }
            }
        }
        System.out.println(num);
    }

}
