package priv.pront.code.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 一些项目要占用高一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你一个项目开始的时间和结束的时间
 * (给你一个数组，里面是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行的宣讲的次数最多。返回这个最多的宣讲次数
 * @Author: pront
 * @Time:2022-09-04 15:50
 */
public class BestArrange {

    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
//            当前的时间点是否早于当前考虑会议的开始时间
            if (timePoint <= programs[i].start) {
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}

