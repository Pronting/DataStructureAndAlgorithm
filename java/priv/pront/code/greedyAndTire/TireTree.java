package priv.pront.code.greedyAndTire;

/**
 * @Description: 前缀树
 * @Author: pront
 * @Time:2022-08-25 10:32
 */
public class TireTree {

    public static class TrieNode {
        public Integer pass;
        public Integer end;
//        HashMap<char,Node> nexts
//        TreeMap<char,Node> nexts
        public TrieNode[] nexts; // 当字符种类较多可以使用哈希表或者有序表;


        public TrieNode() {
            this.pass = 0;
            this.end = 0;
//            a-z
//            nexts[0] == 0 没有走向‘a’的道路
//            nexts[0] != 0 有走向‘a’的道路
            this.nexts = new TrieNode[26];
        }

        public static class Trie {
            private TrieNode root;  //头节点，pass代表加入多少个字符串

            public Trie() {
                root = new TrieNode();
            }


            public void insert(String word) {
                if (word == null) {
                    return;
                }
                char[] chs = word.toCharArray();
                TrieNode node = root;
                node.pass++;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {  //从左到右遍历字符
                    index = chs[i] - 'a'; //由字符决定走那一条路
                    if (node.nexts[index] == null) {
                        node.nexts[index] = new TrieNode();
                    }
                    node = node.nexts[index];
                    node.pass++;
                }
                node.end++;
            }


            public void delete(String word) {
                if (search(word) != 0) {
                    char[] chs = word.toCharArray();
                    TrieNode node = root;
                    node.pass--;
                    int index;
                    for (int i = 0; i < chs.length; i++) {
                        index = chs[i] - 'a';
                        if (--node.nexts[index].pass == 0) {
                            node.nexts[index] = null;
                            return;
                        }
                        node = node.nexts[index];
                    }
                    node.end--;
                }
            }

            public int search(String word) {
                if (word == null) {
                    return 0;
                }
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                }
                return node.end;
            }


            public int prefixNumber(String pre) {
                if (pre == null) {
                    return 0;
                }
                char[] chs = pre.toCharArray();
                TrieNode node = root;
                int index;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                }
                return node.pass;
            }
        }
    }
}
