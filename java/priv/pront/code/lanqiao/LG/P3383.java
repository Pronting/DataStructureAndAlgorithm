package priv.pront.code.lanqiao.LG;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: pront
 * @Time:2022-11-21 20:03
 */
public class P3383 {

//    private static void searchLessKPrime(int n, int q) {
////        for (int i = 1; i <= q; i++) {
////            List<Integer> primeList = getPrime2(i, n);
////            System.out.println("第 " + i + "到 " + (i + n - 1) + " 中" + "第 " + i + "小的数字是 ----->" + primeList.get(i-1));
////        }
//
//        System.out.println(n +" " +q);
//        for (int i = 0; i < q; i++) {
//            Scanner sc = new Scanner(System.in);
//            int k = sc.nextInt();
//            List<Integer> prime1 = getPrime1(k);
//            prime1.get(1);
//        }
//    }


    private static List<Integer> getPrime1(int N){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i =1; i <= N; i++) {
            list.add(i);
        }
//        1不是素数
        list.set(1, 0);
        int x = (int) Math.sqrt(N);
        for (int i = 2; i <= x; i++) {
            if (list.get(i) != 0) {
                int a = i * i;
                while (a <= N) {
                    list.set(a, 0);
                    a += i;
                }
            }
        }
        return list.stream().filter(i -> i != 0).collect(Collectors.toList());
    }


    private static List<Integer> getPrime2(int range) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i <= range ; i++) {
            list.add(i);
        }
//        1不是素数
        list.set(1, 0);
        int x = (int) Math.sqrt(range);
        for (int i = 2; i <= x; i++) {
            if (list.get(i) != 0) {
                int a = i * i;
                while (a <= range) {
                    list.set(a, 0);
                    a += i;
                }
            }
        }
        return list.stream().filter(i -> i != 0).collect(Collectors.toList());

    }






//    private static List<Integer> getPrime(int index, int range) {
//        List<Integer> primeList = new ArrayList<>();
//        Map<Integer, Integer> numberIndexMap = new HashMap<>();
//        int startIndex = 0;
//        for (int i = index; i < index + range; i++) {
//            primeList.add(i);
//            numberIndexMap.put(i, startIndex++);
//            if (i == 1) {
//                primeList.set(index - 1, 0);
//            }
//        }
//
//        int x = (int) Math.sqrt(index + range);
//
//
//        for (int i = 2; i <= x; i++) {
//            if (primeList.get(i) != 0) {
//                int a = i * i;
//                while (a <= index + range) {
//                    primeList.set(a, 0);
//                    a += i;
//                }
//            }
//        }
//
//        for (int i = 0; i <= x; i++) {
//            if (primeList.get(i) != 0) {
//                int a = primeList.get(i) * primeList.get(i);
//                while (a < index + range) {
//                    int j = numberIndexMap.get(a);
//                    primeList.set(j, 0);
//                    a += primeList.get(i);
//                }
//            }
//        }
//        List<Integer> prime = primeList.stream().filter(i -> i != 0).collect(Collectors.toList());
//        return primeList.stream().filter(i -> i >= index).collect(Collectors.toList());
//
//    }


    public static void main(String[] args) {



//        Scanner scan = new Scanner(System.in);
//        int n,q = scan.nextInt();
//        System.out.println(n +" " +q);
//        for (int i = 0; i < q; i++) {
//            Scanner sc = new Scanner(System.in);
//            int k = sc.nextInt();
//            List<Integer> prime1 = getPrime1(n);
//            System.out.println(prime1.get(k - 1));
//        }



//        searchLessKPrime(100, 5);
//        List<Integer> prime3 = getPrime(4, 100);
//        System.out.println(prime3);
//        System.out.println(prime3.get(4 - 1));

    }
}
