package edu.wz.cs.leetcode.hard;

/**
 * 273. Integer to English Words<br>
 * https://leetcode.com/problems/integer-to-english-words<br><br>
 * 
 * Convert a non-negative integer to its English words representation. Given input is guaranteed to be less than 2^31 - 1.<br><br>
 * 
 * Hint:<br>
 * 1. Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.<br>
 * 2. Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and 
 * convert just that chunk to words.<br>
 * 3. There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? 
 * (middle chunk is zero and should not be printed out)
 */
public class IntegerToEnglishWords {
    
    private static final String[] BEFORE_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                               "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String solution(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        int i = 0;
        String res = "";
        
        while (num > 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + THOUSANDS[i] + " " + res;
            }
            num /= 1000;
            i++;
        }
        return res.trim();
    }
    
    private static String helper(int num) {
        if (num == 0) {
            return "";
        }
        else if (num < 20) {
            return BEFORE_20[num] + " ";
        }
        else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        }
        else {
            return BEFORE_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(IntegerToEnglishWords.solution(123));
        System.out.println(IntegerToEnglishWords.solution(12345));
        System.out.println(IntegerToEnglishWords.solution(1234567));
    }
    
}
