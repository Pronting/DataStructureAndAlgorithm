package priv.pront.code.leetcode.linkedList;

import java.util.HashMap;
import java.util.Map;

public class L146_LRUCache {

    class LinkedNode{
        int key;
        LinkedNode prev;
        LinkedNode next;
        int val;

        LinkedNode(){}
        LinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, LinkedNode> cache;
    LinkedNode head, tail;
    int capacity;
    int size;

    L146_LRUCache(int capacity){
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int key){
        LinkedNode node = cache.get(key);
        if(node == null) return -1;
        move2head(node);
        return node.val;
    }

    public void put(int key, int value){
        LinkedNode node = cache.get(key);
        if(node == null){
            node = new LinkedNode(key, value);
            add2head(node);
            size++;
            cache.put(key, node);
            if(size > capacity){
                LinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }else{
            node.val = value;
            move2head(node);
        }
    }

    private void add2head(LinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    private void move2head(LinkedNode node){
        remove(node);
        add2head(node);

    }

    private void remove(LinkedNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private LinkedNode removeTail(){
        LinkedNode node = tail.prev;
        remove(node);
        return node;
    }
}
