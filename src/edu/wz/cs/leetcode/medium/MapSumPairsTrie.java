package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs<br>
 * https://leetcode.com/problems/map-sum-pairs<br><br>
 * 
 * Use trie
 */
public class MapSumPairsTrie {

    private static class TrieNode {
        Map<Character, TrieNode> children;
        int value;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            value = 0;
        }
    }
    
    private TrieNode root;
    
    public MapSumPairsTrie() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode current = root;
        for (char c : key.toCharArray()) {
            TrieNode next = current.children.get(c);
            if (next == null) {
                next = new TrieNode();
                current.children.put(c, next);
            }
            current = next;
        }
        current.value = val;
    }
    
    public int sum(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = current.children.get(c);
            if (next == null) {
                return 0;
            }
            current = next;
        }
        return dfs(current);
    }
    
    private int dfs(TrieNode node) {
        int sum = 0;
        for (char c : node.children.keySet()) {
            sum += dfs(node.children.get(c));
        }
        return sum + node.value;
    }
    
    public static void main(String[] args) {
        MapSumPairsTrie msp = new MapSumPairsTrie();
        msp.insert("apple", 3);
        System.out.println(msp.sum("apple"));
        System.out.println(msp.sum("ap"));
        msp.insert("app", 2);
        System.out.println(msp.sum("app"));
        System.out.println(msp.sum("ap"));   
    }
    
}
