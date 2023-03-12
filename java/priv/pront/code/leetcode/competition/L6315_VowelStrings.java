package priv.pront.code.leetcode.competition;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-12 10:30
 */
public class L6315_VowelStrings {

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for(int i = left; i <= right; i++){
            if(set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L6315_VowelStrings().vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1, 4));
    }
}
