package priv.pront.code.od;

import java.util.*;

public class E2024_火星文计算 {

    static Map<Character, Integer> pri = new HashMap<>();

    static {
        pri.put('#', 2);
        pri.put('$', 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        Stack<Long> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i= 0;
        int n = chs.length;
        while(i < n){
            char c = chs[i];
            if(Character.isDigit(c)){
                long num = 0;
                while(i < n && Character.isDigit(chs[i])){
                    num = num * 10 + (chs[i] - '0');
                    i++;
                }
                nums.push(num);
                continue;
            }

            while(!ops.isEmpty() && pri.get(ops.peek()) >= pri.get(c)){
                cal(nums, ops);
            }
            ops.push(c);
            i++;
        }

        while(!ops.isEmpty()){
            cal(nums, ops);
        }
        System.out.println(nums.pop());
    }

    private static void cal(Stack<Long> nums, Stack<Character> ops){
        long y = nums.pop();
        long x = nums.pop();
        char type = ops.pop();
        long ans;
        if(type == '#'){
            ans = 4 * x + 3 * y + 2;
        }else{
            ans = 2 * x + y + 3;
        }
        nums.push(ans);
    }
}
