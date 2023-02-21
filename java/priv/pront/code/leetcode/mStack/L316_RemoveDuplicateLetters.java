package priv.pront.code.leetcode.mStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-19 15:59
 */
public class L316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];

//  last index location of character
        for(int i = 0; i< s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // 添加哨兵节点
        stack.addLast('a');
        HashSet<Character> visited = new HashSet<>();

        for(int i = 0 ; i < s.length(); i++){
            char curChar = s.charAt(i);
            // 说明之前放过
            if(visited.contains(curChar)){
                continue;
            }

//          后面还有相同子字母并且呈现单调递减
            while(stack.peekLast() > curChar && lastIndex[stack.peekLast() - 'a'] > i){
                visited.remove(stack.peekLast());
                stack.pollLast();
            }
            visited.add(curChar);
            stack.addLast(curChar);
        }

        stack.removeFirst();
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
