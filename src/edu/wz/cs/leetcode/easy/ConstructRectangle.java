package edu.wz.cs.leetcode.easy;

import java.util.Arrays;

/**
 * 492. Construct the Rectangle<br>
 * https://leetcode.com/problems/construct-the-rectangle<br><br>
 * 
 * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectanglar
 * web page's area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following
 * requirements:<br>
 * 
 * 1. The area of the rectangular web page you designed must equal to the given target area.<br>
 * 2. The width W should not be larger than the length L, which means L >= W.<br>
 * 3. The difference between L and W should be as small as possible<br>
 * 
 * You need to output the length L and the width W of the web page you designed in sequence.<br><br>
 * 
 * Note:<br>
 * 1. The given area won't exceed 10,000,000 and is a positive integer.<br>
 * 2. The web pages's width and length you designed must be positive integers.
 */
public class ConstructRectangle {

    public static int[] solution(int area) {        
        int sqrt = (int) Math.sqrt(area);
        if (area % sqrt == 0) {
            return new int[] {sqrt, sqrt};
        }
        
        sqrt--;
        while (sqrt > 1) {
            if (area % sqrt == 0) {
                return new int[] {area / sqrt, sqrt};
            }
            sqrt--;
        }
        
        return new int[] {area, 1};
    }
    
    public static int[] solutionAlt(int area) {
        int[] result = {area, 1};
        int sqrt = (int) Math.sqrt(area);
        for (int W = sqrt; W >= 1; W--) {
            if (area % W == 0) {
                result[0] = area / W;
                result[1] = W;
                break;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ConstructRectangle.solution(4)));
        System.out.println(Arrays.toString(ConstructRectangle.solution(7)));
        
        System.out.println(Arrays.toString(ConstructRectangle.solutionAlt(4)));
        System.out.println(Arrays.toString(ConstructRectangle.solutionAlt(7)));
    }

}
