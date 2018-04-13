package edu.wz.cs.leetcode.medium;

/**
 * 211. Add and Search Word - Data structure design<br>
 * https://leetcode.com/problems/add-and-search-word-data-structure-design<br><br>
 * 
 * Design a data structure that supports the following two operations:<br>
 * void addWord(word)<br>
 * bool search(word)<br>
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it 
 * can represent any one letter.<br>
 * 
 * Note: You may assume that all words are consist of lowercase letters a-z.
 */
public class AddSearchWordDataStructureDesign {
    
    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public AddSearchWordDataStructureDesign() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(TrieNode curr, String word, int i) {
        int n = word.length();
        if (i == n) {
            return curr.isWord;
        }
        
        if (word.charAt(i) == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && search(child, word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
        else {
            return curr.children[word.charAt(i) - 'a'] != null
                && search(curr.children[word.charAt(i) - 'a'], word, i + 1);
        }
    }
    
    public static void main(String[] args) {
        AddSearchWordDataStructureDesign addSearchWordDataStructureDesign = new AddSearchWordDataStructureDesign();
        addSearchWordDataStructureDesign.addWord("bad");
        addSearchWordDataStructureDesign.addWord("dad");
        addSearchWordDataStructureDesign.addWord("mad");
        System.out.println(addSearchWordDataStructureDesign.search("pad"));
        System.out.println(addSearchWordDataStructureDesign.search("bad"));
        System.out.println(addSearchWordDataStructureDesign.search(".ad"));
        System.out.println(addSearchWordDataStructureDesign.search("b.."));
    }

}
