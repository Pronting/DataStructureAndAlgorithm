package priv.pront.code.lanqiao.LG.P.binarySearch;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-01-12 14:51
 */
public class P2249_me {

    private static List<Integer> num = new ArrayList<>();

    private static List<Integer> question = new ArrayList<>();



    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            num.add(scanner.nextInt());
//        }
//        for (int i = 0; i < m; i++) {
//            question.add(scanner.nextInt());
//        }

        num.add(1);
        num.add(1);
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(40);

        question.add(3);
        question.add(2);
        question.add(1);
        question.add(40);
        question.add(32);
        question.add(10);


        getNumIndex(num, question);
    }

    private static void getNumIndex(List<Integer> num, List<Integer> question) {
        for (int Q : question) {
            int l = 0;
            int r = num.size() - 1;
//            while (l <= r) {
//                int mid = getMid(l, r);
//                if (num.get(mid) < Q && l != r) {
//                    l = mid;
//                } else if (num.get(mid) > Q) {
//                    r = mid - 1;
//                } else if (num.get(mid) == Q) {
//                    l = mid;
//                    System.out.println(l + 1);
//                    break;
//                } else {
//                    System.out.println(-1);
//                    break;
//                }
//            }
            while (l <= r) {
                int mid = getMid(l, r);
                if (num.get(mid) < Q && l != r) {
                    l = mid;
                } else if (num.get(mid) > Q) {
                    r = mid - 1;
                } else if (num.get(mid) == Q) {
                    l = mid;
                    System.out.println(l + 1);
                    break;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }

    private static int getMid(int l, int r) {
        return l == 0 ? r / 2 : (r - l + 1) / 2 + l;
    }
}
