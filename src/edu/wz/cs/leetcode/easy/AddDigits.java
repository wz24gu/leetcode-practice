package edu.wz.cs.leetcode.easy;

/**
 * 258. Add Digits<br>
 * https://leetcode.com/problems/add-digits<br><br>
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.<br>
 * 
 * For example:<br>
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.<br>
 * 
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 * 
 * Hint:<br>
 * 1. A naive implementation of the above process is trivial. Could you come up with other methods?<br>
 * 2. What are all the possible results?
 * 3. How do they occur, periodically or randomly?
 */
public class AddDigits {
    
    public static int solution(int num) {        
        while (num > 9) {
            int sum = 0;
            while (num != 0) {
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        
        return num;
    }
    
    public static int solutionX(int num) {
        return 1 + (num - 1) % 9;  // digit root problem
    }
    
    public static int solutionXX(int num) {
        if (num == 0) {
            return 0;
        }
        else if (num % 9 == 0) {
            return 9;
        }
        else {
            return num % 9;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(AddDigits.solution(38));
        System.out.println(AddDigits.solutionX(38));
        System.out.println(AddDigits.solutionXX(38));
    }

}
