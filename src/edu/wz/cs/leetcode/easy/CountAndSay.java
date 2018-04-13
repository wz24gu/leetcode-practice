package edu.wz.cs.leetcode.easy;

/**
 * 38. Count and Say<br>
 * https://leetcode.com/problems/count-and-say<br><br>
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:<br>
 * 1.     1<br>
 * 2.     11<br>
 * 3.     21<br>
 * 4.     1211<br>
 * 5.     111221<br>
 * 
 * 1 is read off as "one 1" or 11.<br>
 * 11 is read off as "two 1s" or 21.<br>
 * 21 is read off as "one 2, then one 1" or 1211.<br>
 * 
 * Given an integer n, generate the nth term of the count-and-say sequence.<br>
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
    
    public static String solution(int n) {
        String result = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            int size = result.length();
            for (int i = 0; i < size; i++) {
                int count = 1;
                while (i + 1 < size && result.charAt(i) == result.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count).append(result.charAt(i));
            }
            result = sb.toString();
        }
        return result;
    }
    
    public static String solutionAlt(int n) {
        String[] result = new String[n];
        result[0] = "1";
        
        for (int i = 1; i < n; i++) {
            char[] arr = result[i-1].toCharArray();
            StringBuilder sb = new StringBuilder();
            
            char c = arr[0];
            int count = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == c) {
                    count++;
                }
                else {
                    sb.append(count + "").append(c);
                    c = arr[j];
                    count = 1;
                }
            }
            sb.append(count).append(c);
            
            result[i] = sb.toString();
        }
        
        return result[n-1];
    }
    
    public static String solutionX(int n) {
        String prev = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            int m = prev.length();
            for (int j = 0; j < m; j++) {
                int count = 1;
                while (j + 1 < m && prev.charAt(j) == prev.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(count).append(prev.charAt(j));
            }
            prev = sb.toString();
        }
        
        return prev;
    }
    
    
    public static void main(String[] args) {
        System.out.println(CountAndSay.solution(1));
        System.out.println(CountAndSay.solution(2));
        System.out.println(CountAndSay.solution(3));
        System.out.println(CountAndSay.solution(4));
        System.out.println(CountAndSay.solution(5));
        
        System.out.println(CountAndSay.solutionAlt(1));
        System.out.println(CountAndSay.solutionAlt(2));
        System.out.println(CountAndSay.solutionAlt(3));
        System.out.println(CountAndSay.solutionAlt(4));
        System.out.println(CountAndSay.solutionAlt(5));
        
        System.out.println(CountAndSay.solutionX(1));
        System.out.println(CountAndSay.solutionX(2));
        System.out.println(CountAndSay.solutionX(3));
        System.out.println(CountAndSay.solutionX(4));
        System.out.println(CountAndSay.solutionX(5));
    }

}
