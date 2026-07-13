package priv.pront.code.od;

import java.util.*;

public class E2024_字符串摘要 {

    static class Info{
        char ch;
        int cnt;

        public Info(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }
        int i = 0;
        List<Info> list = new ArrayList<>();
        while (i < sb.length()) {
            char ch = sb.charAt(i);
            int j = i;
            while(j < sb.length() && ch == sb.charAt(j)) j++;
            int len = j - i;
            if(len > 1){
                list.add(new Info(ch, len));
            }else{
                map.put(ch, map.get(ch) - 1);
                list.add(new Info(ch, map.get(ch)));
            }
            i = j;
        }
        list.sort((a, b) ->{
            if(a.cnt != b.cnt) return b.cnt - a.cnt;
            else return a.ch - b.ch;
        });

        StringBuilder ans = new StringBuilder();
        for (Info node : list) {
            ans.append(node.ch).append(node.cnt);
        }

        System.out.println(ans);
    }
}
