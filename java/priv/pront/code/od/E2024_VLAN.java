package priv.pront.code.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class E2024_VLAN {


    static class Item{
        int a, b;
        public Item(int a, int b){
            this.a = a;
            this.b = b;
        }
        public Item(int a){
            this.a = a;
        }

        @Override
        public String toString() {
            if(b > 0){
                return a + "-" + b;
            }else{
                return a + "";
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(",");
        int delete = sc.nextInt();
        List<Item> list = new ArrayList<>();
        for (String cur : line) {
            Item item;
            if(isNumber(cur)) item = new Item(Integer.parseInt(cur));
            else{
                String[] num = cur.split("-");
                item = new Item(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
            }
            list.add(item);
        }
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            int a = item.a;
            int b = item.b;
            if(b == 0 && a == delete) list.remove(item);
            if(delete < a || delete > b) continue;
            if(a < delete && b > delete){
                list.remove(item);
                list.add(new Item(a, delete - 1 == a ? 0 : delete - 1));
                list.add(new Item(delete + 1 == b ? b : delete + 1, delete + 1 == b ? 0 : b));
            }
        }

        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.a - o2.a;
            }
        });

        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            if(i < list.size() - 1) System.out.print(",");
        }

    }

    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
