package edu.wz.cs.leetcode.hard;

/**
 * 302. Smallest Rectangle Enclosing Black Pixels<br/>
 * 
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are
 * connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the
 * location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses 
 * all black pixels.<br/>
 * 
 * For example, given the following image:<br/>
 * [<br/>
 *   "0010",<br/>
 *   "0110",<br/>
 *   "0100"<br/>
 * ]<br/>
 * and x = 0, y = 2, Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
    
    public static int solution(int[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            throw new IllegalArgumentException();
        }
        
        int row = image.length;
        int col = image[0].length;
        int top = x;
        int bottom = x;
        int left = y;
        int right = y;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (image[i][j] == 1) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        
        return (bottom - top + 1) * (right - left + 1);  // top, bottom, left and right are 1s
    }
    
    public static int solutionX(int[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 2) {
            throw new IllegalArgumentException();
        }
        
        int row = image.length;
        int col = image[0].length;
        int left = searchColumn(image, 0, y, 0, row, true);
        int right = searchColumn(image, y + 1, col, 0, row, false);
        int top = searchRow(image, 0, x, left, right, true);
        int bottom = searchRow(image, x + 1, row, left, right, false);
        
        return (bottom - top) * (right - left);  // left and top are 1s, right and bottom are 0s
    }
    
    private static int searchColumn(int[][] image,
            int left, int right, int top, int bottom, boolean opt) {
        while (left < right) {
            int k = top;
            int mid = left + (right - left) / 2;
            while (k < bottom && image[k][mid] == 0) {
                k++;  // check the column mid from top to bottom
            }
            
            if (k < bottom == opt) {  // found 1
                right = mid;
            }
            else {
                left = mid + 1;
            }            
        }
        return left;  // left will be the first 1 and right will be the first 0
    }
    
    private static int searchRow(int[][] image,
            int top, int bottom, int left, int right, boolean opt) {
        while (top < bottom) {
            int k = left;
            int mid = top + (bottom - top) / 2;
            while (k < right && image[mid][k] == 0) {
                k++;  // check the row mid from left to right
            }
            
            if (k < right == opt) {  // found 1
                bottom = mid;
            }
            else {
                top = mid + 1;
            }
        }
        return top;
    }
    
    public static void main(String[] args) {
        int[][] image = { {0, 0, 1, 0},
                          {0, 1, 1, 0},
                          {0, 1, 0, 0} };
        System.out.println(SmallestRectangleEnclosingBlackPixels.solution(image, 0, 2));
        System.out.println(SmallestRectangleEnclosingBlackPixels.solutionX(image, 0, 2));
    }

}
