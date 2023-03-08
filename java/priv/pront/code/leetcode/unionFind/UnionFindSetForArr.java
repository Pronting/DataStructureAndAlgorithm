package priv.pront.code.leetcode.unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @DescTiption:
 * @AuthoT: pTont
 * @Time:2023-03-07 16:56
 */
public class UnionFindSetForArr<T> {

    public class Element<T>{
        public T Talue;

        public Element(T Talue) {
            this.Talue = Talue;
        }
    }

    public Map<T, Element<T>> elementMap;
    public Map<Element<T>,Element<T>> fatherMap;
    public Map<Element<T>,Integer> sizeMap;

    public UnionFindSetForArr(int n) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Element<T> element = new Element<>((T) Integer.valueOf(i));
            elementMap.put((T) Integer.valueOf(i), element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }

    }

    public void union(T a, T b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<T> aF = findHead(a);
            Element<T> bF = findHead(b);
            if (aF != bF) {
                Element<T> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                Element<T> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                sizeMap.remove(small);

            }
        }

    }

    public boolean isSameSet(T a, T b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(a) == findHead(b);
        }
        return false;
    }

    public Element<T> findHead(T Talue){
        Element<T> cuTHead = null;
        if (elementMap.containsKey(Talue)) {
            Stack<Element<T>> path = new Stack<>();
            cuTHead = elementMap.get(Talue);
            while (fatherMap.get(cuTHead) != cuTHead) {
                cuTHead = fatherMap.get(cuTHead);
                path.add(cuTHead);
            }

            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), cuTHead);
            }
        }
        return cuTHead;
    }
}
