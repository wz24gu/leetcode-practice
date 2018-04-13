package edu.wz.cs.leetcode.medium;

public class ImplementTrieIII {
    
    /** Initialize your data structure here. */
    public ImplementTrieIII() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }
    
    public static void main(String[] args) {
        ImplementTrieIII trie = new ImplementTrieIII();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

}
