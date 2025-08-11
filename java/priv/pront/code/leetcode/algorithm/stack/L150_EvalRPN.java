package priv.pront.code.leetcode.algorithm.stack;


import java.util.Stack;

public class L150_EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                int sum = 0;
                if(s.equals("+")) sum = b + a;
                else if(s.equals("-")) sum = b - a;
                else if(s.equals("*")) sum = b * a;
                else if(s.equals("/")) sum = b / a;
                stack.push(sum);
            }else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
