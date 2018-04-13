package edu.wz.cs.leetcode.easy;

/**
 * 223. Rectangle Area<br/>
 * https://leetcode.com/problems/rectangle-area<br/><br/>
 * 
 * Find the total area covered by two rectilinear rectangles in a 2D plane.<br/>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.<br/>
 * Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    
    public static int solution(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);  // tricky y axis
        
        if (C <= E || G <= A || B >= H || F >= D) {
            return sum;
        }
        
        return sum - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
    
    public static void main(String[] args) {
        System.out.println(RectangleArea.solution(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
