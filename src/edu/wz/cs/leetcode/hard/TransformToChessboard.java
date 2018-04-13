package edu.wz.cs.leetcode.hard;

/**
 * 782. Transform to Chessboard<br>
 * https://leetcode.com/problems/transform-to-chessboard<br><br>
 * 
 * An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with 
 * each other.<br>
 * 
 * What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 
 * 4-directionally adjacent? If the task is impossible, return -1.<br><br>
 * 
 * Note:<br>
 * 1. board will have the same number of rows and columns, a number in the range [2, 30].<br>
 * 2. board[i][j] will be only 0s or 1s.
 */
public class TransformToChessboard {
    
    public static int solution(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int n = board.length;
        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) {
                rowSwap++;
            }
            if (board[0][i] == i % 2) {
                colSwap++;
            }
        }
        
        if (n / 2 > rowSum || rowSum > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > colSum || colSum > (n + 1) / 2) {
            return -1;
        }
        
        if (n % 2 == 1) {
            if (colSwap % 2 == 1) {
                colSwap = n - colSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = n - rowSwap;
            }
        }
        else {
            colSwap = Math.min(n - colSwap, colSwap);
            rowSwap = Math.min(n - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }
    
    public static void main(String[] args) {
        int[][] board = { {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1} };
        System.out.println(TransformToChessboard.solution(board));
        
        int[][] board2 = { {0, 1}, {1, 0} };
        System.out.println(TransformToChessboard.solution(board2));
        
        int[][] board3 = { {1, 0}, {1, 0} };
        System.out.println(TransformToChessboard.solution(board3));
    }

}
