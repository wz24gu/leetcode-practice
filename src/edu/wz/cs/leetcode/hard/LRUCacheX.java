package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache<br>
 * https://leetcode.com/problems/lru-cache<br><br>
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
 * get and put.<br>
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.<br>
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.<br>
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LRUCacheX {
    
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCacheX(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;            
        }
        Node node = map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
       if (map.containsKey(key)) {
           Node node = map.get(key);
           node.val = value;
           remove(node);
           addToHead(node);
           return;
       }
       
       if (capacity == map.size()) {
           map.remove(tail.prev.key);
           remove(tail.prev);
       }
       Node node = new Node(key, value);
       addToHead(node);
       map.put(key, node);
    }
    
    public static void main(String[] args) {
        LRUCacheX cache = new LRUCacheX(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
