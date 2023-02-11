package priv.pront.code.leetcode.algorithm.bs;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-11 20:00
 */
public class L275_HIndexII {

//    ! by self 错误
    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations.length - mid > citations[mid]) {
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return  citations.length - left;
    }

    public int hIndex2(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }

    public int hIndex3(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        if (citations[r] == 0){
            return 0;
        }
        while (l < r){
            int p = (l + r) / 2;
            if (citations.length - p > citations[p]){
                l = p + 1;
            } else {
                r = p;
            }
        }
        return citations.length - l;

    }


    public static void main(String[] args) {
        int[] num = {1, 2, 100};
        System.out.println(hIndex(num));

    }
}
