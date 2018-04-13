package edu.wz.cs.leetcode.easy;

/**
 * 171. Excel Sheet Column Number<br>
 * https://leetcode.com/problems/excel-sheet-column-number<br><br>
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.<br>
 * 
 * For example:<br>
 * A -> 1<br>
 * B -> 2<br>
 * C -> 3<br>
 * Z -> 26<br>
 * AA -> 27<br>
 * AB -> 28<br>
 */
public class ExcelSheetColumnNumber {

    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum = sum * 26 + (c - 'A' + 1);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(ExcelSheetColumnNumber.solution("A"));
        System.out.println(ExcelSheetColumnNumber.solution("Z"));
        System.out.println(ExcelSheetColumnNumber.solution("AA"));
        System.out.println(ExcelSheetColumnNumber.solution("AB"));
    }

}
