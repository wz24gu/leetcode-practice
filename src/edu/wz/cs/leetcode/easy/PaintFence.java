package edu.wz.cs.leetcode.easy;

/**
 * 276. Paint Fence<br>
 * https://leetcode.com/problems/paint-fence<br><br>
 * 
 * There is a fence with n posts, each post can be painted with one of the k colors.<br>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.<br>
 * Return the total number of ways you can paint the fence.<br>
 * 
 * Note: n and k are non-negative integers.
 */
public class PaintFence {
    
    public static int solution(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        
        // get the first 2 posts
        int same = k * 1;
        int diff = k * (k - 1);
        
        // start with the 3rd post
        for (int i = 3; i <= n; i++) {
            int temp = diff;
            diff = (diff + same) * (k - 1);
            same = temp;            
        }
        
        return same + diff;        
    }
    
    public static void main(String[] args) {
        System.out.println(PaintFence.solution(3, 3));
    }

}
