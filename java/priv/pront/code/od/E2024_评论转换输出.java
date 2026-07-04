package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 在一个博客网站上，每篇博客都有评论。每一条评论都是一个非空英文字母字符串。评论具有树状结构，除了根评论外，每个评论都有一个父评论。当评论保存时，使用以下格式：首先是评论的内容； 然后是回复当前评论的数量。 最后是当前评论的所有了评论。(子评论使用相同的格式嵌套存储) 所有元素之间都用单个逗号分隔。例如，如果评论如下：
 *
 * a950295cdf7e4e0685ee7f213e57563a.png
 *
 * 第一条评论是"helo,2,ok,0,bye,0"，第二条评论是"test,0"，第三条评论是"one,1,two,1,a,0"。
 *
 * 所有评论被保存成"hello,2,ok,0.bye,0,test,0,one,1,two,1,a,0"。
 *
 * 对于上述格式的评论，请以另外一种格式打印：
 *
 * 首先打印评论嵌套的最大深度。 然后是打印n行，第 i (1 ≤ i ≤ n) 行对应于嵌套级别为 i 的评论 (根评论的嵌套级别为1)。 对于第 i 行，嵌套级别为的评论按照它们出现的顺序打印，用空格分隔开
 *
 * 输入描述
 * 一行评论。由英文字母、数字和英文逗号组成。
 *
 * 保证每个评论都是由英文字符组成的非空字符串。
 * 每个评论的数量都是整数 (至少由一个数字组成)。
 * 整个字符串的长度不超过10^6。
 * 给定的评论结构保证是合法的
 *
 *
 * 输出描述
 * 按照给定的格式打印评论。对于每一级嵌套，评论应该按照输入中的顺序打印
 */
public class E2024_评论转换输出 {

    static int idx;
    static List<List<String>> list = new ArrayList<>();
    static String[] arr;
    static int maxLevel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = sc.nextLine().split(",");
        int n = arr.length;
        while(idx < n){
            dfs(1);
        }
        System.out.println(maxLevel);
        for (List<String> strings : list) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int level){
        String cur = arr[idx++];
        int num = Integer.parseInt(arr[idx++]);
        while(list.size() < level){
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(cur);
        maxLevel = Math.max(maxLevel, level);

        for(int i = 0; i < num; i++){
            dfs(level + 1);
        }

    }
}
