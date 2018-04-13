package edu.wz.cs.leetcode.easy;

/**
 * 157. Read N Characters Given Read4<br>
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.<br>
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters 
 * left in the file.<br>
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.<br>
 * 
 * Note: The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 {
    
    private static int read4(char[] buffer) {
        return 4;
    }
    
    public static int solution(char[] buffer, int n) {
        boolean eof = false;
        char[] temp = new char[4];
        int total = 0;
        
        while (!eof && total < n) {
            int count = read4(temp);
            if (count < 4) {
                eof = true;
            }
            
            count = Math.min(count, n - total);
            for (int i = 0; i < count; i++) {
                buffer[total] = temp[i];
                total++;
            }
        }
        
        return total;
    }

}
