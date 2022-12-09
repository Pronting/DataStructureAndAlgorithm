package priv.pront.code.structure.hash;

/**
 * @Description: 等概率返回5~7
 * @Author: pront
 * @Time:2022-11-25 16:11
 */
public class Rand5ToRand7 {

    /**
     * 等概率返回1~5(已知)
     *
     * @return ...
     */
    private static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 等概率返回13~21(已知)
     *
     * @return 。。。
     */
    private static int f1() {
        return (int) (Math.random() * 9) + 13;
    }

    /**
     * 加工为01发生器
     *
     * @return 。。。
     */
    private static int r01A() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    /**
     * 由f1()函数加工而来的01发生器
     *
     * @return
     */
    private static int r01B() {
        int res = 0;
        int cur;
        do {
            cur = f1();
            res = cur < 17 ? 0 : 1;
        } while (cur == 21);
        return res;
    }

    /**
     * 30~59等概率返回
     * @return
     */
    private static int g1() {
        int res = 0;
        do {
            res = (r01B() << 4 + r01B() << 3 + r01B() << 2 + r01B() << 1 + r01B());
        } while (res > 29);
        return res + 30;
    }

    /**
     * 1~7等概率
     *
     * @return ...
     */
    private static int g() {
        int res;
        do {
            res = (r01A() << 2 + r01A() << 1 + r01A());
        } while (res == 7);
        return res + 1;
    }


    /**
     * 给定一个函数f,以p概率返回0，以1-p概率返回1，加工出01发生器
     * 01  ---->   1
     * 10 ----->   2
     * p * (1-p)
     * @return
     */
    private static int f3(){
        return 0;
    }
}
