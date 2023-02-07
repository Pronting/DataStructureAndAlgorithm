package priv.pront.code.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-02-07 14:44
 */
public class L118_YangHuiTriangle {

    public static  List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        list = new ArrayList<>();
        list.add(1);
        list.add(1);
        res.add(list);

        for(int i = 3; i <= numRows; i++ ){
            int index = 0;
            int index2 = 1;
            List<Integer> list2 = new ArrayList<>();
            list2.add(1);
            List<Integer> curList = res.get(res.size() - 1);
            while(index2 != curList.size()){
                list2.add(curList.get(index)+curList.get(index2));
                index++;
                index2++;
            }
            list2.add(1);
            res.add(list2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
