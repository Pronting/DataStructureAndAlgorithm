package priv.pront.code.algorithm.watchdog;

/**
 * @Description: 一个8只能装8个苹果，6只能装6个苹果的袋子，求最少的袋子装完所有苹果
 * @Author: pront
 * @Time:2022-11-18 17:23
 */
public class AppleMinBags {

    private static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - bag8 * 8;
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    private static int minBagBase(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }


    private static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }


    private static int generateRandomApple(int max) {
        return (int) (Math.random() * max);
    }

    public static void main(String[]args) {
        int apple = generateRandomApple(2000);

//        for (int i = 1; i < 100; i++) {
//            int bags = minBags(i);
//            System.out.println(i+" --> "+bags);
//        }


        for (int i = 0; i < 10000; i++) {
            if (minBags(apple) != minBagAwesome(apple)) {
                System.out.println("ooops!");
                break;
            }
        }
    }


}
