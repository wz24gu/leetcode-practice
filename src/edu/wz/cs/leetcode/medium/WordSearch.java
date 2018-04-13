package edu.wz.cs.leetcode.medium;

/**
 * 79. Word Search<br>
 * https://leetcode.com/problems/word-search<br><br>
 * 
 * Given a 2D board and a word, find if the word exists in the grid.<br>
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
 * or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {
    
    public static boolean solution(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, i, j, word, 0, marked)) {
                    return true;
                }
            }
        }
        return false;   
    }
    
    private static boolean search(char[][] board, int i, int j, String word, int idx, boolean[][] marked) {
        if (idx == word.length()) {
            return true;
        }
        
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || marked[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        marked[i][j] = true;
        boolean result = search(board, i + 1, j, word, idx + 1, marked)
                      || search(board, i - 1, j, word, idx + 1, marked)
                      || search(board, i, j + 1, word, idx + 1, marked)
                      || search(board, i, j - 1, word, idx + 1, marked);
        marked[i][j] = false;
        
        return result;
    }
    
    public static void main(String[] args) {
        char[][] board = { {'A', 'B', 'C', 'E'},
                           {'S', 'F', 'C', 'S'},
                           {'A', 'D', 'E', 'E'} };
        System.out.println(WordSearch.solution(board, "ABCCED"));
        System.out.println(WordSearch.solution(board, "SEE"));
        System.out.println(WordSearch.solution(board, "ABCB"));
    }

}
