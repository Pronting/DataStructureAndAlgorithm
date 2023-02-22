package priv.pront.code.leetcode.algorithm.other;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-22 15:46
 */
public class L242_IAnagram {

    public static boolean isAnagram(String s, String t) {

        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i = 0; i< sArr.length; i++){
            sArr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i< tArr.length; i++){
            tArr[t.charAt(i) - 'a']++;
        }


        for(int i = 0; i < sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

    }
}
