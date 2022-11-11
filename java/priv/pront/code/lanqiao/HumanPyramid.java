package priv.pront.code.lanqiao;

/**
 * @Description: 叠罗汉问题
 * @Author: pront
 * @Time:2022-10-18 13:47
 */
public class HumanPyramid {

    public static char humanPyramid(String word) {
        if (word == null) {
            return ' ';
        }
        char[] chars = word.toCharArray();
        return process(chars);

    }

    public static char process(char[] chars) {
        if (chars.length == 1) {
            return chars[0];
        }
        char[] nextLevelChars = new char[chars.length - 1];
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                nextLevelChars[i] = 'A';
            }else{
                nextLevelChars[i] = 'B';
            }
        }
        return process(nextLevelChars);
    }


    public static void main(String[] args) {
        String basicLevel = "ABABBA";
        char c = humanPyramid(basicLevel);
        System.out.println(c);

    }
}
