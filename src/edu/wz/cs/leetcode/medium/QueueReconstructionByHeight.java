package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 506. Queue Reconstruction by Height<br>
 * https://leetcode.com/problems/queue-reconstruction-by-height<br><br>
 * 
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers(h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater
 * than or equal to h. Write an algorithm to reconstruct the queue.<br><br>
 * 
 * Note: The number of people is less than 1,100.
 */
public class QueueReconstructionByHeight {
    
    public static int[][] solution(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] p, int[] q) {
                if (p[0] == q[0]) {
                    return p[1] - q[1];
                }
                else {
                    return q[0] - p[0];  // desc
                }
            }
        });
        
        int n = people.length;
        List<int[]> list = new ArrayList<>(n);
        for (int[] person : people) {
            list.add(person[1], person);
        }
        
        int[][] result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] people = { {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2} };
        int[][] result = QueueReconstructionByHeight.solution(people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

}
