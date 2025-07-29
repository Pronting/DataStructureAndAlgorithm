package priv.pront.code.leetcode.str;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class L6_Zconvert {

    public String convert(String s, int numRows) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            if(flag) count--;
            else count++;
            String item = s.substring(i, i + 1);
            List<String> list = map.getOrDefault(count, new ArrayList<>());
            list.add(item);
            map.put(count, list);
            if(count == numRows) flag = true;
            if(count == 1) flag = false;
        }
        Set<Integer> set = map.keySet();
        String ans = "";
        for(Integer i : set){
            List<String> list = map.get(i);
            for(String ss : list) ans += ss;
        }
        return ans;
    }

    public static void main(String[] args) {
        L6_Zconvert main = new L6_Zconvert();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String ans = main.convert(s, numRows);
        System.out.println(ans);
    }


}
