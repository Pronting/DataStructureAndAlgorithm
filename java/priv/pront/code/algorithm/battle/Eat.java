package priv.pront.code.algorithm.battle;

/**
 * @Description: 博弈吃草问题4的N次方
 * @Author: pront
 * @Time:2022-11-18 19:05
 */
public class Eat {

    private static String winner1(int n) {
//         1  2  3  4  5
//         先 后 先 先  后

        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
//        先手决定吃的草
        int base = 1;
        while (base <= n) {
            if (winner1(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {
                break;
            }
            base *= 4;
        }
        return "后手";
    }


    private static String winner2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "先手";
        }else{
            return "后手";
        }
    }

    private static int generateRandomGrass(int max) {
        return (int) (Math.random() * max);
    }



    public static void main(String[] args) {
        int grass = generateRandomGrass(2000);

//        for (int i = 1; i < 100; i++) {
//            String s = winner1(i);
//            System.out.println(i + "---> " + s);
//        }



        for (int i = 0; i < 10000; i++) {
            if (!winner1(grass).equals(winner2(grass))) {
                System.out.println("ooops");
            }
        }
    }
}
