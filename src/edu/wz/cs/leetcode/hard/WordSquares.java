package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 425. Word Squares<br/>
 * 
 * Given a set of words (without duplicates), find all word squares you can build from them. A sequence of words forms
 * a valid word square if the kth row and column read the exact same string, where 0 <= k < max(numRows, numColumns).<br/>
 * 
 * For example, the word sequence ["ball", "area", "lead", "lady"] forms a word square because each word reads the
 * same both horizontally and vertically.<br/><br/>
 * "b a l l"<br/>
 * "a r e a"<br/>
 * "l e a d"<br/>
 * "l a d y"<br/>
 * 
 * Note:<br/>
 * 1. There are at least 1 and at most 1000 words.<br/>
 * 2. All words will have the exact same length.<br/>
 * 3. Word length is at least 1 and at most 5.<br/>
 * 4. Each word contains only lowercase English alphabet a-z.
 */
public class WordSquares {
    
    private static class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];  // for lowercase letter only
        }
    }
    
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isWord = true;
        }
        return root;
    }
    
    private static TrieNode search(TrieNode root, String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null;
            }
            current = current.children[index];
        }
        return current;
    }
    
    private static String getPrefix(List<String> square, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(square.get(i).charAt(index));
        }
        return sb.toString();
    }
    
    private static void getChildren(TrieNode node, String s, List<String> children) {
        if (node.isWord) {
            children.add(s);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                getChildren(node.children[i], s + (char) ('a' + i), children);
            }
        }
    }
    
    public static List<List<String>> solution(String[] words) {
        if (words == null || words.length == 0) {
            throw new IllegalArgumentException();
        }
        
        TrieNode root = buildTrie(words);
        List<List<String>> squares = new ArrayList<>();
        for (String word : words) {
            List<String> square = new ArrayList<>();
            square.add(word);  // try each word as the first row
            helper(root, word.length(), square, squares);
        }
        return squares;
    }
    
    private static void helper(TrieNode root, int len, List<String> square, List<List<String>> squares) {
        if (square.size() == len) {
            squares.add(new ArrayList<>(square));
            return;
        }
        
        // search for the prefix, if there is no prefix found, then we give up
        String prefix = getPrefix(square, square.size());
        TrieNode node = search(root, prefix);
        if (node == null) {
            return;
        }
        
        List<String> children = new ArrayList<>();
        getChildren(node, prefix, children);
        for (String child : children) {
            square.add(child);
            helper(root, len, square, squares);
            square.remove(square.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(WordSquares.solution(words));
    }
    
}
