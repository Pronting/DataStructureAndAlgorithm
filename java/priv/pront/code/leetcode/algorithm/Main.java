package priv.pront.code.leetcode.algorithm;

public class Main {

    public boolean isPalindrome(String s) {
        String origin = "";
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) >= 97 && s.charAt(i) < 97 + 26) || (s.charAt(i) >= 65 && s.charAt(i) < 65 + 26))
                origin += s.substring(i, i + 1).toLowerCase();
        }
        String reverse = "";
        for(int i = origin.length() - 1; i >= 0; i--) reverse += origin.substring(i, i + 1);
        for(int i = 0; i < origin.length(); i++){
            if(origin.charAt(i) != reverse.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) '0');
    }
}
