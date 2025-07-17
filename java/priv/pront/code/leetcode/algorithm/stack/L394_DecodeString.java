package priv.pront.code.leetcode.algorithm.stack;

import java.util.Stack;

public class L394_DecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ']'){
                String temp = "";
                while(!stack.peek().equals("[")){
                   temp = stack.pop() + temp;
                }
                String str = temp;
                stack.pop();
                int num = Integer.parseInt(stack.pop());
                while(-- num > 0) temp = temp + str;
                stack.push(temp);
            }else{
                if(Character.isDigit(s.charAt(i))){
                    int digit = isDigit(s, i);
                    stack.push(s.substring(i, i + digit));
                    i = i + digit - 1;
                }else{
                    stack.push(s.substring(i, i + 1));
                }

            }
        }

        while(!stack.isEmpty()) stack2.push(stack.pop());

        while(!stack2.isEmpty()) sb.append(stack2.pop());
        return sb.toString();
    }

    private int isDigit(String s, int i){
        int count = 0;
        for (; i < s.length(); i++) {
            if(!Character.isDigit(s.charAt(i))) return count;
            if (Character.isDigit(s.charAt(i))) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        L394_DecodeString l394 = new L394_DecodeString();
        System.out.println(l394.decodeString("100[leetcode]"));
//        System.out.println(l394.isDigit("100[leetcode]", 0));
    }
}
