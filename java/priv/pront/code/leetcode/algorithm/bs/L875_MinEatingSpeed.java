package priv.pront.code.leetcode.algorithm.bs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-16 12:04
 */
public class L875_MinEatingSpeed {

    //    timeout
    public static int minEatingSpeed1(int[] piles, int h) {
        long sum = 0;
        for (int cur : piles) {
            sum += cur;
        }
        long left = 0;
        long right = sum;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(piles, mid, h) > 0) {
                left = mid + 1;
            } else if ((check(piles, mid, h) == 0 && check(piles, mid - 1, h) == 0) || check(piles, mid, h) < 0) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }
        return -1;

    }

    public static int check(int[] piles, long mid, int h) {
        int ans = 0;
        for (int cur : piles) {
            if (cur <= mid) {
                ans++;
            } else {
                while (cur != 0) {
                    if (cur < mid) {
                        ans++;
                        break;
                    }
                    cur -= mid;
                    ans++;
                }
            }
        }
        return ans - h;
    }


    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        // 速度最小的时候，耗时最长
        int left = 1;
        // 速度最大的时候，耗时最短
        int right = maxVal;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (calculateSum(piles, mid) > H) {
                // 耗时太多，说明速度太慢了，下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int calculateSum(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;
    }



    /**
     * 如果返回的小时数严格大于 H，就不符合题意
     *
     * @param piles
     * @param speed
     * @return 需要的小时数
     */
    private int function(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            // 上取整可以这样写
            sum += (pile + speed - 1) / speed;
        }
        return sum;

    }


    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed1(piles, 5));

    }
}
