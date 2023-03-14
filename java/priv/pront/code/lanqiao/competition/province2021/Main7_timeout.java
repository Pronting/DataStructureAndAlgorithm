package priv.pront.code.lanqiao.competition.province2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-14 11:08
 */
public class Main7_timeout {

    static int f = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();

        for(int i = 0; i< S.length(); i++){
            Map<Character, Integer> wordTimeMap = new HashMap<>();
            for (int j = i; j < S.length(); j++) {
                if (wordTimeMap.containsKey(S.charAt(j))) {
                    wordTimeMap.put(S.charAt(j), wordTimeMap.get(S.charAt(j)) + 1);
                }else{
                    wordTimeMap.put(S.charAt(j), 1);
                }
                process(wordTimeMap);
            }
        }

        System.out.println(f);
    }

    public static void process(Map<Character,Integer> wordTime){
        for (Map.Entry<Character, Integer> cur : wordTime.entrySet()) {
            if (cur.getValue() == 1) {
                f++;
            }
        }
    }
}
