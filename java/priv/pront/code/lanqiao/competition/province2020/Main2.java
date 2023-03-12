package priv.pront.code.lanqiao.competition.province2020;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-12 12:00
 */
public class Main2 {

    public static void main(String[] args) {
        String pre = "EaFnjISplhFviDhwFbEjRjfIBBkRyY";
        char[] chs = pre.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('y', 'a');
        map.put('Y', 'A');
        map.put('x', 'b');
        map.put('X', 'B');
        map.put('m', 'c');
        map.put('M', 'C');
        map.put('d', 'd');
        map.put('D', 'D');
        map.put('a', 'e');
        map.put('A', 'E');
        map.put('c', 'f');
        map.put('C', 'F');
        map.put('i', 'g');
        map.put('I', 'G');
        map.put('k', 'h');
        map.put('K', 'H');
        map.put('n', 'i');
        map.put('N', 'I');
        map.put('t', 'j');
        map.put('T', 'J');
        map.put('j', 'k');
        map.put('J', 'K');
        map.put('h', 'l');
        map.put('H', 'L');
        map.put('q', 'm');
        map.put('Q', 'M');
        map.put('l', 'n');
        map.put('L', 'N');
        map.put('g', 'o');
        map.put('G', 'O');
        map.put('o', 'p');
        map.put('O', 'P');
        map.put('u', 'q');
        map.put('U', 'Q');
        map.put('f', 'r');
        map.put('F', 'R');
        map.put('s', 's');
        map.put('S', 'S');
        map.put('z', 't');
        map.put('Z', 'T');
        map.put('p', 'u');
        map.put('P', 'U');
        map.put('w', 'v');
        map.put('W', 'V');
        map.put('b', 'w');
        map.put('B', 'W');
        map.put('r', 'x');
        map.put('R', 'X');
        map.put('e', 'y');
        map.put('E', 'Y');
        map.put('v', 'z');
        map.put('V', 'Z');
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                chs[i] = map.get(chs[i]);
            }
        }
        System.out.println(new String(chs));

    }
}
