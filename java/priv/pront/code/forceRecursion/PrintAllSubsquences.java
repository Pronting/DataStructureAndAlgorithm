package priv.pront.code.forceRecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 打印所有字符串的子序列
 * @Author: pront
 * @Time:2022-09-07 10:31
 */
public class PrintAllSubsquences {

    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    /**
     * 当前来到i位置，要和不要，走两条路
     * 之前的选择，形成的结果是str
     * 这种做法比较省空间，但是时间复杂度是一样的
     * @param chs
     * @param i
     */
    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);  //要当前字符的路
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i + 1);  //不要当前字符的路，0字符打印不出来
        chs[i] = tmp;
    }

    public static void function(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    /**
     * 递归函数
     * @param chs 当前的字符串
     * @param i 当前来到i位置，要和不要，走两条路
     * @param res 之前字符char类型的列表
     */
    public static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            printList(res);
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(chs[i]);
        process(chs, i + 1, resKeep);  //要当前字符的路
        List<Character> resNoInclude = copyList(res);
        process(chs, i + 1, resNoInclude);  //不要当前字符的路
    }

    public static void printList(List<Character> res) {
        // ...;
    }

    public static List<Character> copyList(List<Character> list){
        return null;
    }


    public static void main(String[] args) {
        String test = "abc";
        printAllSubsquence(test);
    }

}
