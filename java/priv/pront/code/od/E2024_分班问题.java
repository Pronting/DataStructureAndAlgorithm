package priv.pront.code.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 儿园两个班的小朋友在排队时混在了一起，每位小朋友都知道自己是否与前面一位小朋友同班，请你帮忙把同班的小朋友找出来。
 *
 * 小朋友的编号是整数，与前一位小朋友同班用Y表示，不同班用N表示。
 *
 * 输入描述
 * 输入为空格分开的小朋友编号和是否同班标志。
 *
 * 比如：6/N 2/Y 3/N 4/Y，表示4位小朋友，2和6同班，3和2不同班，4和3同班。
 *
 * 其中，小朋友总数不超过999，每个小朋友编号大于0，小于等于999。
 *
 * 不考虑输入格式错误问题。
 *
 * 输出描述
 * 输出为两行，每一行记录一个班小朋友的编号，编号用空格分开，且：
 *
 * 编号需按照大小升序排列，分班记录中第一个编号小的排在第一行。
 * 若只有一个班的小朋友，第二行为空行。
 * 若输入不符合要求，则直接输出字符串ERROR。
 */
public class E2024_分班问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        List<List<Integer>> list = new ArrayList<>();
        for (String str : s) {
            String[] split = str.split("/");
            int no = Integer.parseInt(split[0]);
            String type = split[1];
            if(no == 1 || type.equals("N")){
                List<Integer> cls = new ArrayList<>();
                cls.add(no);
                list.add(cls);
            }else{
                List<Integer> cls = list.get(list.size() - 1);
                cls.add(no);
            }

        }
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
