package edu.wz.cs.leetcode.easy;

/**
 * 292. Nim Game<br>
 * https://leetcode.com/problems/nim-game<br><br>
 * 
 * You are playing the following Nim Game with your friend: there is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.<br>
 * 
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
 * win the game give the number of stones in the heap.<br>
 * 
 * For example, if there are 4 stones in the heap, then you will never win the game, no matter 1, 2 or 3 stones you
 * remove, the last stone will always be removed by your friend.<br><br>
 * 
 * Hint: if there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be
 * the winner?
 */
public class NimGame {

    public static boolean solution(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(NimGame.solution(4));
    }

}
