package priv.pront.code.leetcode.arr;

import java.util.Stack;

public class L844_BackCompare {
    public boolean backspaceCompare(String s, String t) {
        return process(s).equals(process(t));

    }

    private String process(String s){
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            char c = chs[i];
            if(c == '#') stack.pop();
            else stack.push(chs[i]);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }
    
}
