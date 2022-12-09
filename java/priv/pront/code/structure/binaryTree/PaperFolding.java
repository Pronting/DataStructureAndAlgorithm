package priv.pront.code.structure.binaryTree;

/**
 * @Description: 二叉树的折纸问题
 * @Author: pront
 * @Time:2022-08-16 09:38
 */
public class PaperFolding {

    public static void printAllFolds(int N){
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }

    public static void main(String[]args){
        int N = 3;
        printAllFolds(N);
    }
}
