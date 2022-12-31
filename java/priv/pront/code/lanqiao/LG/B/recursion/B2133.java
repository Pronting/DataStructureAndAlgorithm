package priv.pront.code.lanqiao.LG.B.recursion;

import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-12-31 18:46
 */
// FIXME
public class B2133 {
    public static class Info {
        public Integer allNum;
        public Integer all;

        public Info(Integer curMyNum, Integer all) {
            this.allNum = curMyNum;
            this.all = all;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Info info = getMaxNum(1, n);
        int myNum = getMyNum(n, info);
        System.out.print(myNum);
        System.out.print(" ");
        System.out.print(info.allNum);

    }

    private static Info getMaxNum(int curMaxNum, int target) {
        if (getAll(curMaxNum) > target && (getAll(curMaxNum) - getMyNum(target, new Info(curMaxNum, getAll(curMaxNum))) - target) % 2 == 0) {
            return new Info(curMaxNum, getAll(curMaxNum));
        }
        return getMaxNum(curMaxNum + 1, target);
    }

    private static int getMyNum(int n, Info info) {
        return (info.all - n) / 2;
    }

    private static int getAll(int curMyNum) {
        if (curMyNum == 0) {
            return 0;
        }
        return curMyNum + getAll(curMyNum - 1);
    }
}
