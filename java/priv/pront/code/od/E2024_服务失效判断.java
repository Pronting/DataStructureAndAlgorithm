package priv.pront.code.od;

import priv.pront.code.algorithm.sort.heap.A;

import java.util.*;

/**
 * 题目描述
 * 某系统中有众多服务，每个服务用字符串（只包含字母和数字，长度<=10）唯一标识，服务间可能有依赖关系，如A依赖B，则当B故障时导致A也故障。依赖具有传递性，如A依赖B，B依赖C，当C故障时导致B故障，也导致A故障。给出所有依赖关系，以及当前已知故障服务，要求输出所有正常服务。依赖关系：服务1-服务2 表示“服务1”依赖“服务2”不必考虑输入异常，用例保证：依赖关系列表、故障列表非空，且依赖关系数，故障服务数都不会超过3000，服务标识格式正常。
 *
 * 输入描述
 * 半角逗号分隔的依赖关系列表（换行）
 * 半角逗号分隔的故障服务列表
 *
 *
 * 输出描述
 * 依赖关系列表中提及的所有服务中可以正常工作的服务列表，用半角逗号分隔，按依赖关系列表中出现的次序排序。
 * 特别的，没有正常节点输出单独一个半角逗号
 */
public class E2024_服务失效判断 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] service = sc.nextLine().split(",");
        String[] bads = sc.nextLine().split(",");
        Map<String, List<String>> graph = new HashMap<>();
        List<String> order = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (String s : service) {
            String[] cur = s.split("-");
            graph.putIfAbsent(cur[1], new ArrayList<>());
            graph.get(cur[1]).add(cur[0]);
            if(set.add(cur[0])){
                order.add(cur[0]);
            }
            if(set.add(cur[1])) order.add(cur[1]);

        }
        Queue<String> queue = new LinkedList<>();
        Set<String> bad = new HashSet<>();
        for (String s : bads) {
            if(bad.add(s)){
                queue.add(s);
            }
        }

        while(!queue.isEmpty()){
            String poll = queue.poll();
            if(!graph.containsKey(poll)) continue;
            for(String item : graph.get(poll)){
                if(bad.add(item)) queue.add(item);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : order) {
            if(!bad.contains(s)){
                if(sb.length() > 0) sb.append(",");
                sb.append(s);
            }
        }

        if (sb.length() == 0) {
            System.out.println(",");
        } else {
            System.out.println(sb);
        }


    }
}
