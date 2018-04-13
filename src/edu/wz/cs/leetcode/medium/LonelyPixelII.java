package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 533. Lonely Pixel II<br>
 * https://leetcode.com/problems/lonely-pixel-ii<br><br>
 * 
 * Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels 
 * located at some specific row R and column C that align with all the following rules:<br>
 * 1. Row R and column C both contain exactly N black pixels.<br>
 * 2. For all rows that have a black pixel at column C, they should be exactly the same as row R<br>
 * 
 * The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels 
 * respectively.<br>
 * 
 * Note: The range of width and height of the input 2D array is [1,200].
 */
public class LonelyPixelII {
    
    public static int solution(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) {
            return 0;
        }
        
        int m = picture.length;
        int n = picture[0].length;
        int[] cols = new int[n];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    cols[j]++;
                    count++;
                }
                sb.append(picture[i][j]);
            }
            if (count == N) {
                String currentRow = sb.toString();
                map.put(currentRow, map.getOrDefault(currentRow, 0) + 1);
            }
        }
        System.out.println(map);
        
        int result = 0;
        for (String row : map.keySet()) {
            if (map.get(row) != N) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if (row.charAt(i) == 'B' && cols[i] == N) {
                    result += N;
                }
            }
        }
        return result;        
    }
    
    public static void main(String[] args) {
        char[][] picture = { {'W', 'B', 'W', 'B', 'B', 'W'},    
                             {'W', 'B', 'W', 'B', 'B', 'W'},    
                             {'W', 'B', 'W', 'B', 'B', 'W'},    
                             {'W', 'W', 'B', 'W', 'B', 'W'} };
        System.out.println(LonelyPixelII.solution(picture, 3));
    }

}
