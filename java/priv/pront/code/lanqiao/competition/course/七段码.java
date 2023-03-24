package priv.pront.code.lanqiao.competition.course;

import java.util.*;
// 80
public class 七段码 {

    static int counts = 0;
    static Set<String> set = new HashSet<>();
    static Map<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "abcdefg";
        //初始化
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        ArrayList<String> list5 = new ArrayList<>();
        ArrayList<String> list6 = new ArrayList<>();
        ArrayList<String> list7 = new ArrayList<>();
        list1.add("b");
        list1.add("f");
        list2.add("a");
        list2.add("g");
        list2.add("c");
        list3.add("b");
        list3.add("g");
        list3.add("d");
        list4.add("c");
        list4.add("e");
        list5.add("f");
        list5.add("g");
        list5.add("d");
        list6.add("a");
        list6.add("g");
        list6.add("e");
        list7.add("f");
        list7.add("e");
        list7.add("b");
        list7.add("c");
        map.put("a", list1);
        map.put("b", list2);
        map.put("c", list3);
        map.put("d", list4);
        map.put("e", list5);
        map.put("f", list6);
        map.put("g", list7);

        //求字符串的所有字串
        find("", str, 0);

        System.out.println(counts);
    }

    static void find(String temp, String str, int index) {
        if (index == str.length()) {
            //最后对得到的字串检查是否是一个连通区域
            if (bfsCheck(temp.toCharArray())) counts++;
            return;
        }
        find(temp, str, index + 1);
        find(temp += str.charAt(index), str, index + 1);
    }

    static boolean bfsCheck(char[] strs) {
        //先对简单情形直接判断
        if (strs.length == 0) return false;
        if (strs.length == 1) return true;
        if (strs.length == 2) {
            if (map.get(strs[0] + "").contains(strs[1] + "")) return true;
            else return false;
        }
        LinkedList<String> queue = new LinkedList<>();
        int connect = 1;
        queue.add(strs[0] + "");
        strs[0] = '0';
        while (!queue.isEmpty()) {
            String str = queue.poll();
            ArrayList<String> list = map.get(str);
            for (int i = 0; i < strs.length; i++) {
                if (list != null && list.contains(strs[i] + "")) {
                    connect++;
                    queue.add(strs[i] + "");
                    strs[i] = '0';
                }
            }
        }
        if (connect == strs.length) return true;
        return false;
    }
}
