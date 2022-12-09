package priv.pront.code.structure.hash;

/**
 * @Description:
 * 有40亿个无符号的整型数据，现在给定一个目标数字，判断这个数字是否在这40亿数据中。
 * 创建一个bit类型数组(位图)
 * 将基础类型的数据改写诚bit数组,并实现各种操作
 * @Author: pront
 * @Time:2022-10-21 17:17
 */
public class BitMap {

    public static void main(String[] args) {



        int a = 0;

//        a   32  bit



        int[] arr = new int[10];    // 32bit  *  10  ->320bit

//        arr[0]  int 0 ~ 31
//        arr[1]  int 32 ~ 63
//        arr[2] int 64 ~ 95



        int i = 178;     //想要取得178个bit的状态



        int numIndex = i / 32;
        int bitIndex = i % 32;



//        拿到低178位的状态
        int s = (        (arr[numIndex] >> (bitIndex))        &1);




//        请把第i位的状态改成1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);




//        请把178位的状态改成0
        arr[numIndex] = arr[numIndex] & (~  (1 << bitIndex));




//        请把178位的状态改成0
        i = 178;

    }
}
