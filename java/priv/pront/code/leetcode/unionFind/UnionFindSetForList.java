package priv.pront.code.leetcode.unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Description:
 * @Author: pront
 * @Time:2023-03-07 16:56
 */
public class UnionFindSetForList<V> {

    public class Element<V>{
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public Map<V, Element<V>> elementMap;
    public Map<Element<V>,Element<V>> fatherMap;
    public Map<Element<V>,Integer> sizeMap;

    public UnionFindSetForList(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V v : list) {
            Element<V> element = new Element<>(v);
            elementMap.put(v, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }

    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aF = findHead(a);
            Element<V> bF = findHead(b);
            if (aF != bF) {
                Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                Element<V> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                sizeMap.remove(small);

            }
        }

    }

    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(a) == findHead(b);
        }
        return false;
    }

    public Element<V> findHead(V value){
        Element<V> curHead = null;
        if (elementMap.containsKey(value)) {
            Stack<Element<V>> path = new Stack<>();
            curHead = elementMap.get(value);
            while (fatherMap.get(curHead) != curHead) {
                curHead = fatherMap.get(curHead);
                path.add(curHead);
            }

            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), curHead);
            }
        }
        return curHead;
    }
}
