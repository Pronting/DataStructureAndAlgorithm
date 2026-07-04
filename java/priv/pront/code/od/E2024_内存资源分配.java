package priv.pront.code.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，用户会进行一系列内存申请，需要按需分配内存池中的资源返回申请结果成功失败列表。
 *
 * 分配规则如下：
 *
 * 分配的内存要大于等于内存的申请量，存在满足需求的内存就必须分配，优先分配粒度小的，但内存不能拆分使用；
 * 需要按申请顺序分配，先申请的先分配，有可用内存分配则申请结果为true；
 * 没有可用则返回false。
 * 注意：不考虑内存释放
 *
 * 输入描述
 * 输入为两行字符串
 *
 * 第一行为内存池资源列表，包含内存粒度数据信息，粒度数据间用逗号分割
 *
 * 一个粒度信息内用冒号分割，冒号前为内存粒度大小，冒号后为数量
 * 资源列表不大于1024
 * 每个粒度的数量不大于4096
 * 第二行为申请列表，申请的内存大小间用逗号分割
 *
 * 申请列表不大于100000
 * 如:
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 *
 * 输出描述
 * 输出为内存池分配结果
 *
 * 如true,true,true,false,false
 */
public class E2024_内存资源分配 {

    static class Memory{
        int size;
        int count;
        public Memory(int size, int count){
            this.size = size;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        String[] questions = sc.nextLine().split(",");
        List<Memory> list = new ArrayList<>();
        for (String s : str) {
            String[] item = s.split(":");
            list.add(new Memory(Integer.parseInt(item[0]), Integer.parseInt(item[1])));
        }

        list.sort(new Comparator<Memory>() {
            @Override
            public int compare(Memory o1, Memory o2) {
                return o1.size - o2.size;
            }
        });
        for (String question : questions) {
            int q = Integer.parseInt(question);
            // 二分
            int l = 0, r = list.size() - 1;
            while(l < r){
                int mid = l + r >> 1;
                Memory cur = list.get(mid);
                if(cur.size >= q) r = mid;
                else l = mid + 1;
            }
            if(list.get(l).size >= q && list.get(l).count > 0) {
                list.get(l).count--;
                System.out.println(true);
            }else if(list.get(l).size >= q){
                while(l < list.size()) {
                    if(list.get(l).count > 0) break;
                    l++;
                }
                if(l == list.size()) System.out.println(false);
                else {
                    list.get(l).count--;
                    System.out.println(true);
                }
            }
            else{
                System.out.println(false);
            }
        }
    }
}
