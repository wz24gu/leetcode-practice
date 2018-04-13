package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II<br>
 * https://leetcode.com/problems/pascals-triangle-ii<br><br>
 * 
 * Given an index k, return the kth row of the Pascal's triangle.<br>
 * For example, given k = 3, Return [1,3,3,1].<br>
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    
    public static List<Integer> solution(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> prev = null;
        List<Integer> current = null;
        for (int i = 0; i <= rowIndex; i++) {
            current = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                }
                else {
                    current.add(prev.get(j) + prev.get(j - 1));
                }
            }
            prev = current;
        }
        
        return current;
    }
    
    public static List<Integer> solutionX(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) {
            return result;
        }        
        
        for (int i = 0; i <= rowIndex; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 1; j--) {
                int temp = result.get(j-1) + result.get(j);
                result.set(j, temp);
            }
            result.add(1);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(PascalTriangleII.solution(0));
        System.out.println(PascalTriangleII.solution(1));
        System.out.println(PascalTriangleII.solution(2));
        System.out.println(PascalTriangleII.solution(3));
        System.out.println(PascalTriangleII.solution(4));
        System.out.println(PascalTriangleII.solution(5));
        
        System.out.println(PascalTriangleII.solutionX(0));
        System.out.println(PascalTriangleII.solutionX(1));
        System.out.println(PascalTriangleII.solutionX(2));
        System.out.println(PascalTriangleII.solutionX(3));
        System.out.println(PascalTriangleII.solutionX(4));
        System.out.println(PascalTriangleII.solutionX(5));
    }

}
