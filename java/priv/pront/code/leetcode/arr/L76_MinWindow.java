package priv.pront.code.leetcode.arr;

import java.util.*;

public class L76_MinWindow {

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> omap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) omap.put(c, omap.getOrDefault(c, 0) + 1);

        int sidx = 0;
        int minlength = Integer.MAX_VALUE;
        int l = 0;
        int validCount = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);

            if(omap.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c).equals(omap.get(c))) validCount++;
            }

            while(validCount == omap.size()){
                if(r - l + 1 < minlength){
                    minlength = r - l + 1;
                    sidx = l;
                }
                char lc = s.charAt(l);
                if(omap.containsKey(lc)){
                    if(map.get(lc).equals(omap.get(lc))) validCount--;
                    map.put(lc, map.get(lc) - 1);
                }
                l++;
            }
        }
        return minlength == Integer.MAX_VALUE ? "" : s.substring(sidx, sidx + minlength);
    }

    public static void main(String[] args) {
        System.out.println((int)'1' - 48);
    }

}
