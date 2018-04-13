package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle<br>
 * https://leetcode.com/problems/pascals-triangle<br><br>
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle {
    
    public static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {  // i is from 0 to n-1
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {  // j is from 0 to i
                if (j == 0 || j == i) {
                    list.add(1);  // 1 at the first and the last index
                }
                else {
                    List<Integer> prev = result.get(i-1);
                    list.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(PascalTriangle.solution(5));
    }

}
