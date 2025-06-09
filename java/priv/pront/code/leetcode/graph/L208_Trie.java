package priv.pront.code.leetcode.graph;

public class L208_Trie {

    public TrieNode root;
    public class TrieNode{
        public Integer pass;
        public Integer end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }


    public L208_Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null || word.equals("")) return;
        TrieNode cur = root;
        cur.pass ++;
        char[] chs = word.toCharArray();
        for(int i = 0; i < chs.length; i++){
            int idx = chs[i] - 'a';
            if(cur.nexts[idx] == null){
                cur.nexts[idx] = new TrieNode();
            }
            cur = cur.nexts[idx];
            cur.pass++;

        }
        cur.end++;
    }

    public boolean search(String word) {
        if(word == null) return true;
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < chs.length; i++){
            int idx = chs[i] - 'a';
            if(cur.nexts[idx] == null) return false;
            cur = cur.nexts[idx];
        }
        return cur.end > 0;

    }

    public boolean startsWith(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < chs.length; i++){
            int idx = chs[i] - 'a';
            if(cur.nexts[idx].pass == 0) return false;
            cur = cur.nexts[idx];
        }
        return cur.pass > 0;
    }
}
