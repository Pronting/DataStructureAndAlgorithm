package priv.pront.code.leetcode.algorithm.greedy;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-16 14:56
 */
public class L45_CanJumpII {

    //    方法错误
    public static int jump(int[] nums) {
        int cover = nums[0];
        int times = 0;
        if (nums.length == 1) {
            return 0;
        } else if (cover == 0) {
            return -1;
        } else if (cover >= nums.length - 1) {
            return 1;
        }
        int i = 1;
        for (; i <= cover && i < nums.length; i++) {
            int preCover = cover;
            for (int j = i; j <= preCover && j < nums.length; j++) {
                cover = Math.max(cover, Math.min(j + nums[j], nums.length - 1));
            }
            times++;
            i = cover;
            cover = i + nums[i];
        }
        return times + 1;
    }


    public int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count = 0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i + nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }


    public static int jump3(int[] nums) {
        int n = nums.length;
        boolean[] st = new boolean[n];
        return dfs(0, nums, st, 0, Integer.MAX_VALUE);
    }

    private static int dfs(int idx, int[] nums, boolean[] st, int step, int min) {
        if (idx >= nums.length - 1) {
            min = Math.min(min, step);
        }
        for (int i = idx; i < nums.length; i++) {
            if (!st[i] && i <= idx + nums[idx]) {
                st[i] = true;
                dfs(i, nums, st, step + 1, min);
                st[i] = false;
            }
        }
        return min;

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jump3(arr));

    }

}
