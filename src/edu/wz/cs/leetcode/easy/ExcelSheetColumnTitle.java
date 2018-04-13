package edu.wz.cs.leetcode.easy;

/**
 * 168. Excel Sheet Column Title<br>
 * https://leetcode.com/problems/excel-sheet-column-title<br><br>
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.<br>
 * For example:
 * 1 -> A<br>
 * 2 -> B<br>
 * 3 -> C<br>
 * 26 -> Z<br>
 * 27 -> AA<br>
 * 28 -> AB
 */
public class ExcelSheetColumnTitle {

    public static String solution(int n) {        
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.insert(0, s.charAt(n % 26));
            n /= 26;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnTitle.solution(1));
        System.out.println(ExcelSheetColumnTitle.solution(2));
        System.out.println(ExcelSheetColumnTitle.solution(26));
        System.out.println(ExcelSheetColumnTitle.solution(27));
        System.out.println(ExcelSheetColumnTitle.solution(28));
        System.out.println(ExcelSheetColumnTitle.solution(51));
        System.out.println(ExcelSheetColumnTitle.solution(52));
        System.out.println(ExcelSheetColumnTitle.solution(53));
    }
}
