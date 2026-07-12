package priv.pront.code.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E2024_运维日志排序 {

    static class OpsInfo{
        String origin;
        String format;

        public OpsInfo(String origin, String format) {
            this.format = format;
            this.origin = origin;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<OpsInfo> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            list.add(new OpsInfo(str, handle(str)));
        }
        list.sort(new Comparator<OpsInfo>() {
            @Override
            public int compare(OpsInfo o1, OpsInfo o2) {
                return o1.format.compareTo(o2.format);
            }
        });
        for (OpsInfo opsInfo : list) {
            System.out.println(opsInfo.origin);
        }
    }

    private static String handle(String str) {
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(":");
        for (int i = 0; i < split.length; i++) {
            String cur = split[i];
            if(i != 0) sb.append(":");
            if(i == 2){
                String[] last = cur.split(".");
                for(int j = 0; j < last.length; j++){
                    if(j != 0) sb.append(".");
                    if(j == 0) sb.append(doHandle(last[j], 2));
                    if(j == 1) sb.append(doHandle(last[j], 3));
                }
            }else{
                sb.append(doHandle(cur, 2));
            }
        }
        return sb.toString();
    }

    private static String doHandle(String str, int digit){
        if(str.length() < digit) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digit - str.length(); i++) {
                sb.append("0");
            }
            sb.append(str);
            return sb.toString();
        }
        else return str;
    }


}
