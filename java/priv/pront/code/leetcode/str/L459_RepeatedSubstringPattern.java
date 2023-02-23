package priv.pront.code.leetcode.str;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-23 16:55
 */
public class L459_RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String newStr = s + '1';
        char[] ms = newStr.toCharArray();
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < next.length){
            if(ms[i-1] == ms[cn]){
                next[i++] = ++cn;
            }else if(cn > 0){  // 当前跳到cn位置的字符，和i-1 位置的字符匹配不上
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        int maxMatchLen = next[next.length -1];
        return maxMatchLen > 0 && s.length() % (s.length() - maxMatchLen) == 0;
    }
}
