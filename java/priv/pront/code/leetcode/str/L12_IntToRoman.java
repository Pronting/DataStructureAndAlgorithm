package priv.pront.code.leetcode.str;


/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-24 10:20
 */
public class L12_IntToRoman {

    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

//    4ms
    public static String intToRoman(int num, StringBuilder sb) {

        if (num >= 900 && num < 1000) {
            return intToRoman(num - 900, sb.append("CM"));
        } else if (num >= 400 && num < 500) {
            return intToRoman(num - 400, sb.append("CD"));
        } else if (num >= 90 && num < 100) {
            return intToRoman(num - 90, sb.append("XC"));
        } else if (num >= 40 && num < 50) {
            return intToRoman(num - 40, sb.append("XL"));
        } else if (num == 9) {
            return intToRoman(num - 9, sb.append("IX"));
        } else if (num == 4) {
            return intToRoman(num - 9, sb.append("IV"));
        }

        int digit = (num + "").length();
        if (digit >= 4) {
            for (int i = 0; i < num / 1000; i++) {
                sb.append("M");
            }
            return intToRoman(num % 1000, sb);
        }
        if (digit == 3 && num / 500 >= 1) {
            for (int i = 0; i < num / 500; i++) {
                sb.append("D");
            }
            return intToRoman(num % 500, sb);
        }

        if (digit == 3 && num / 500 == 0 && num / 100 >= 1) {
            for (int i = 0; i < num / 100; i++) {
                sb.append("C");
            }
            return intToRoman(num % 100, sb);
        }

        if (digit == 2 && num / 50 >= 1) {
            for (int i = 0; i < num / 50; i++) {
                sb.append("L");
            }
            return intToRoman(num % 50, sb);
        }

        if (digit == 2 && num / 50 == 0 && num / 10 >= 1) {
            for (int i = 0; i < num / 10; i++) {
                sb.append("X");
            }
            return intToRoman(num % 10, sb);
        }

        if (digit == 1 && num / 5 >= 1) {
            for (int i = 0; i < num / 5; i++) {
                sb.append("V");
            }
            return intToRoman(num % 5, sb);
        }
        if (digit == 1 && num / 5 == 0 && num >= 1) {
            for (int i = 0; i < num; i++) {
                sb.append("I");
            }
        }
        return sb.toString();
    }

//    3ms
    public String intToRoman2(int num) {
        StringBuilder roman = new StringBuilder();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }



    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num, new StringBuilder()));
    }
}
