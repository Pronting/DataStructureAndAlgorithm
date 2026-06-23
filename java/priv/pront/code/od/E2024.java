package priv.pront.code.od;

import java.util.Scanner;

/**
 * 存在一种虚拟IPv4地址，由4小节组成，每节的范围为0~255，以#号间隔，虚拟IPv4地址可以转换为一个32位的整数，例如：
 *
 * 128#0#255#255，转换为32位整数的结果为2147549183（0x8000FFFF）
 *
 * 1#0#0#0，转换为32位整数的结果为16777216（0x01000000）
 *
 * 现以字符串形式给出一个虚拟IPv4地址，限制第1小节的范围为1128，即每一节范围分别为(1128)#(0255)#(0255)#(0~255)，要求每个IPv4地址只能对应到唯一的整数上。如果是非法IPv4，返回invalid IP
 *
 * 输入描述
 * 输入一行，虚拟IPv4地址格式字符串
 *
 * 输出描述
 * 输出一行，按照要求输出整型或者特定字符
 */
public class E2024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("#");
        if(split.length != 4){
            System.out.println("Invalid IP");
            return;
        }
        for(int i = 0; i < 4; i++){
            if(!isNumber(split[i])) {
                System.out.println("Invalid IP");
                return;
            }
            if(i == 0){
                int val = Integer.valueOf(split[i]);
                if(val < 0 || val > 128){
                    System.out.println("Invalid IP");
                    return;
                }
            }else{
                int val = Integer.valueOf(split[i]);
                if(val < 0 || val > 255){
                    System.out.println("Invalid IP");
                    return;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += (int)(Integer.parseInt(split[i]) * Math.pow(256, 3 - i));
        }
        System.out.println(sum);


    }

    public static boolean isNumber(String str){
        try{
            Integer.valueOf(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }
}
