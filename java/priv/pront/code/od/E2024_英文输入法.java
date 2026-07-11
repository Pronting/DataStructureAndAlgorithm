package priv.pront.code.od;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class E2024_英文输入法 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine(); // 输入一段由英文单词word和标点符号组成的语句
        String prefix = br.readLine(); // 输入一个英文单词前缀
        sentence = sentence.replaceAll("[^a-zA-Z]", " "); // 将标点符号替换为空格
        Set<String> wordSet = new TreeSet<>(); // 存储单词的集合，自动去重且按照字典序排序
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            wordSet.add(word);
        }
        StringBuilder ans = new StringBuilder();
        for (String s : wordSet) { // 遍历单词集合
            if (s.startsWith(prefix)) { // 如果单词以前缀开头
                ans.append(s).append(" "); // 将单词加入答案字符串
            }
        }
        if (ans.length() > 0) { // 如果答案字符串不为空
            System.out.println(ans.toString().trim()); // 输出单词序列
        } else {
            System.out.println(prefix); // 否则输出前缀
        }
    }
}
