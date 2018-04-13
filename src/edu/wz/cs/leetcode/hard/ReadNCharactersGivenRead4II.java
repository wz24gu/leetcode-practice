package edu.wz.cs.leetcode.hard;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times<br>
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times<br><br>
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.<br>
 * 
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters 
 * left in the file.<br>
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.<br>
 * 
 * Note: The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4II {
    
    private static int read = 0;
    private static int write = 0;
    private static char[] buffer = new char[4];
    
    private static int read4(char[] buffer) {
        return 4;
    }
    
    public static int solution(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            if (read == write) {
                write = read4(buffer);
                read = 0;
                if (write == 0) {  // empty
                    return i;
                }
            }
            buf[i] = buffer[read++];
        }
        return n;
    }

}
