package priv.pront.code.greedyAndTire;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description: 两个集合中取一个放入另一个使两个集合平均值提升
 * 请保证arr1无重复值，arr2无重复值，且arr1,arr2肯定有数字
 * @Author: pront
 * @Time:2022-11-22 18:45
 */
public class MagicOp {

    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += arr2[i];
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }

//        平均值不相等
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
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


    public static double avg(double sum, int size) {
        return 2.0;
    }
}
