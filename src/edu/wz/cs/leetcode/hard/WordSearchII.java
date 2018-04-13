package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II<br>
 * https://leetcode.com/problems/word-search-ii<br><br>
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.<br>
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.<br>
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII {
    
    private static class TrieNode {
        TrieNode[] children;
        String word;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    public static List<String> solution(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0
                || words == null || words.length == 0) {
            return result;
        }
        
        TrieNode root = buildTrie(words);
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    private static void dfs(char[][] board, int i, int j, TrieNode curr, List<String> result) {
        char c = board[i][j];
        if (c == '1' || curr.children[c - 'a'] == null) {
            return;
        }
        
        curr = curr.children[c - 'a'];
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        
        board[i][j] = '1';
        if (i > 0) {
            dfs(board, i - 1, j, curr, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, curr, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, curr, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, curr, result);
        }
        board[i][j] = c;   
    }
    
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c -'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;   
        }
        return root;
    }
    
    public static void main(String[] args) {
        char[][] board = { {'o', 'a', 'a', 'n'},
                           {'e', 't', 'a', 'e'},
                           {'i', 'h', 'k', 'r'},
                           {'i', 'f', 'l', 'v'} };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(WordSearchII.solution(board, words));
    }

}
