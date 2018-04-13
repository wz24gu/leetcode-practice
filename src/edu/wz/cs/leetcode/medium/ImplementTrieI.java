package edu.wz.cs.leetcode.medium;

/**
 * 208. Implement Trie (Prefix Tree)<br>
 * https://leetcode.com/problems/implement-trie-prefix-tree<br><br>
 * 
 * Implement a trie with insert, search, and startsWith methods.<br>
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrieI {
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public ImplementTrieI() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    
    public static void main(String[] args) {
        ImplementTrieI trie = new ImplementTrieI();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

}
