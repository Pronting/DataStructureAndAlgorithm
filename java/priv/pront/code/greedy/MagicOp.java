package priv.pront.code.greedy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 两个集合中取一个放入另一个使两个集合平均值提升
 * 请保证arr1无重复值，arr2无重复值，且arr1,arr2肯定有数字
 * @Author: pront
 * @Time:2022-11-22 18:45
 */
public class MagicOp {

    private static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int j : arr1) {
            sum1 += j;
        }
        double sum2 = 0;
        for (int j : arr2) {
            sum2 += j;
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }

//        平均值不相等
        int[] arrMore,arrLess;
        double sumMore,sumLess;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
//        操作了多少次
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            double cur = arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) && !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }


    private static double avg(double sum, int size) {
        return sum / (double) (size);
    }
}
