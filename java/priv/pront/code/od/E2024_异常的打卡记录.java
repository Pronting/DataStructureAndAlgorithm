package priv.pront.code.od;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * 考勤记录是分析和考核职工工作时间利用情况的原始依据，也是计算职工工资的原始依据，为了正确地计算职工工资和监督工资基金使用情况，公司决定对员工的手机打卡记录进行异常排查。如果出现以下两种情况，则认为打卡异常：实际设备号与注册设备号不一样 或者，同一个员工的两个打卡记录的时间小于60分钟并且打卡距离超过5km。 给定打卡记录的字符串数组 clockRecords（每个打卡记录组成为：工号;时间（分钟）;打卡距离（km）;实际设备号;注册设备号），返回其中异常的打卡记录（按输入顺序输出）
 *
 * 输入描述
 * 第一行输入为N，表示打卡记录数；
 *
 * 之后的N行为打卡记录，每一行为一条打卡记录。
 *
 * 备注
 * clockRecords长度 ≤ 1000
 * clockRecords[i] 格式：{id},{time},{distance},{actualDeviceNumber},{registeredDeviceNumber}id由6位数字组成  time由整数组成，范围为0 ~ 1000 distance由整数组成，范围为0 ~100 actualDeviceNumber与registeredDeviceNumber由四位大写字母组成.
 * 输出描述
 */
public class E2024_异常的打卡记录 {

    static class Info{
        int id;
        int minute;
        int distance;
        String actualDeviceNumber;
        String registeredDeviceNumber;

        public Info(int id, int minute, int distance, String actualDeviceNumber, String registeredDeviceNumber) {
            this.id = id;;
            this.minute = minute;
            this.distance = distance;
            this.actualDeviceNumber = actualDeviceNumber;
            this.registeredDeviceNumber = registeredDeviceNumber;
        }

        @Override
        public String toString() {
            return id + "," + minute + "," + distance + "," + actualDeviceNumber + "," + registeredDeviceNumber;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<Integer, List<Info>> map = new LinkedHashMap<>();
        for(int i = 0; i < n; i++){
            String[] split = sc.nextLine().split(",");
            int id = Integer.parseInt(split[0]);
            Info info = new Info(id, Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3], split[4]);
            if (!map.containsKey(id)) {
                List<Info> list = new ArrayList<>();
                list.add(info);
                map.put(id, list);
            }else{
                map.get(id).add(info);
            }
        }

        for (Map.Entry<Integer, List<Info>> entry : map.entrySet()){
            List<Info> value = entry.getValue();
            if (value.size() < 2) {
                Info info = value.get(0);
                check(info);
            }else{
                Info info1 = value.get(0);
                check(info1);
                Info info2 = value.get(1);
                check(info2);
                if(Math.abs(info1.distance - info2.distance) > 5 && Math.abs(info1.minute - info2.minute) < 60){
                    System.out.println(info1);
                    System.out.println(info2);
                }
            }
        }
    }

    private static void check(Info info) {
        if (!info.registeredDeviceNumber.equals(info.actualDeviceNumber)) {
            System.out.println(info);
        }
    }
}
