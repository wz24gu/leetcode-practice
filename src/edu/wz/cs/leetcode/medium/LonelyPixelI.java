package edu.wz.cs.leetcode.medium;

/**
 * 531. Lonely Pixel I<br>
 * https://leetcode.com/problems/lonely-pixel-i<br><br>
 * 
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels. The picture is 
 * represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.<br>
 * 
 * A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't 
 * have any other black pixels.<br>
 * 
 * Note: The range of width and height of the input 2D array is [1,500].
 */
public class LonelyPixelI {

    public static int solution(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        int m = picture.length;
        int n = picture[0].length;
        
        // keep a boolean of columns, skip it if it has a lonely pixel
        boolean[] col = new boolean[n];
        
        for (int i = 0; i < m; i++) {            
            for (int j = 0; j < n; j++) {
                if (col[j]) {
                    continue;
                }
                if (picture[i][j] == 'B' && isLonely(picture, i, j)) {
                    count++;
                    col[j] = true;
                    break;
                }
            }
        }
        
        return count;
    }
    
    private static boolean isLonely(char[][] picture, int i, int j) {
        int rows = picture.length;
        int cols = picture[0].length;
        for (int r = 0; r < rows; r++) {
            if (r != i && picture[r][j] == 'B') {
                return false;
            }
        }        
        for (int c = 0; c < cols; c++) {
            if (c != j && picture[i][c] == 'B') {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] picture = { {'W', 'W', 'B'},
                             {'W', 'B', 'W'},
                             {'B', 'W', 'W'} };
        System.out.println(LonelyPixelI.solution(picture));
    }

}
