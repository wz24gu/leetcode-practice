package edu.wz.cs.leetcode.easy;

/**
 * 800. Similar RGB Color<br>
 * https://leetcode.com/problems/similar-rgb-color<br><br>
 * 
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.<br>
 * 
 * The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the 
 * color "#1155cc".<br>
 * 
 * Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.<br>
 * 
 * Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, 
 * it can be represented as some "#XYZ".<br><br>
 * 
 * Note:<br>
 * 1. color is a string of length 7.<br>
 * 2. color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f<br>
 * 3. Any answer which has the same (highest) similarity as the best answer will be accepted.<br>
 * 4. All inputs and outputs should use lowercase letters, and the output is 7 characters.
 */
public class SimilarRGBColor {
    
    public static String solution(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        
        int n = color.length();
        for (int i = 1; i < n; i += 2) {
            sb.append(helper(color.charAt(i), color.charAt(i + 1)));
        }
        return sb.toString();
    }
    
    private static String helper(char c1, char c2) {
        int d1 = Character.isDigit(c1) ? c1 - '0' : 10 + c1 - 'a';
        int d2 = Character.isDigit(c2) ? c2 - '0' : 10 + c2 - 'a';
        int sum = d1 * 16 + d2;
        
        int idx = sum / 17;
        int remainder = sum % 17;
        if (remainder > 17 / 2) {
            idx++;
        }
        
        char c;
        if (idx >= 0 && idx <= 9) {
            c = (char) ('0' + idx);
        }
        else {
            c = (char) ('a' + idx - 10);
        }
        return String.valueOf(c) + String.valueOf(c);
    }
    
    public static void main(String[] args) {
        System.out.println(SimilarRGBColor.solution("#09f166"));
    }

}
