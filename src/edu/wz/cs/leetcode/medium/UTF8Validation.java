package edu.wz.cs.leetcode.medium;

/**
 * 393. UTF-8 Validation<br>
 * https://leetcode.com/problems/utf-8-validation<br><br>
 * 
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:<br>
 * 1. For 1-byte character, the first bit is a 0, followed by its unicode code.<br>
 * 2. For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most 
 * significant 2 bits being 10.<br>
 * 
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.<br>
 * 
 * Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. 
 * This means each integer represents only 1 byte of data.
 */
public class UTF8Validation {
    
    public static boolean solution(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            if (data[i] < 0b10000000) {  // start with 0, ASCII
                continue;
            }
            else {
                int count = 0;
                int val = data[i];
                for (int j = 7; j >= 0; j--) {
                    if (val >= Math.pow(2, j)) {  // don't use regular &, because the int has 32 bits
                        count++;
                        val -= Math.pow(2, j);
                    }
                    else {
                        break;
                    }
                }
                if (count == 1) {
                    return false;
                }
                for (int j = i + 1; j < i + count; j++) {
                    if (data[j] > 0b10111111 || data[j] < 0b10000000) {
                        return false;
                    }
                }
                i += count - 1;
            }
        }
        
        return true;
    }
    
    public static boolean solutionAlt(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        
        int n = data.length;
        for (int i = 0; i < n; i++) {
            int val = data[i];
            if (val > 0b11111111) {
                return false;
            }
            
            int count = 0;
            if ((val & 0b10000000) == 0) {
                count = 1;
            }
            else if ((val & 0b11100000) == 0b11000000) {
                count = 2;
            }
            else if ((val & 0b11110000) == 0b11100000) {
                count = 3;
            }
            else if ((val & 0b11111000) == 0b11110000) {
                count = 4;
            }
            else {
                return false;
            }
            
            for (int j = 1; j < count; j++) {
                if (i + j >= n) {
                    return false;
                }
                if ((data[i+j] & 0b11000000) != 0b10000000) {
                    return false;
                }
            }
            if (count != 0) {
                i = i + count - 1;
            }
        }
        
        return true;
    }
    
    public static boolean solutionX(int[] data) {
        int count = 0;
        for (int d : data) {
            if (count == 0) {
                if (d >> 5 == 0b110) {
                    count = 1;
                }
                else if (d >> 4 == 0b1110) {
                    count = 2;
                }
                else if (d >> 3 == 0b11110) {
                    count = 3;
                }
                else if (d >> 7 != 0) {
                    return false;
                }
            }
            else {
                if (d >> 6 != 0b10) {
                    return false;
                }
                count--;
            }
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
        int[] data = {197, 130, 1};
        System.out.println(UTF8Validation.solution(data));
        System.out.println(UTF8Validation.solutionAlt(data));
        System.out.println(UTF8Validation.solutionX(data));
        
        int[] data2 = {235, 140, 4};
        System.out.println(UTF8Validation.solution(data2));
        System.out.println(UTF8Validation.solutionAlt(data2));
        System.out.println(UTF8Validation.solutionX(data2));
    }

}
