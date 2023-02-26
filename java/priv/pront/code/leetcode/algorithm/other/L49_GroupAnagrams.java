package priv.pront.code.leetcode.algorithm.other;

import java.util.*;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-26 21:59
 */
//TODO 计数
public class L49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
