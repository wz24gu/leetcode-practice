package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 751. IP to CIDR<br>
 * https://leetcode.com/problems/ip-to-cidr<br><br>
 * 
 * Given a start IP address ip and a number of ips we need to cover n, return a representation of the range as a list 
 * (of smallest possible length) of CIDR blocks.<br>
 * 
 * A CIDR block is a string consisting of an IP, followed by a slash, and then the prefix length. For example: 
 * "123.45.67.89/20". That prefix length "20" represents the number of common prefix bits in the specified range.<br><br>
 * 
 * Note:<br>
 * 1. ip will be a valid IPv4 address.<br>
 * 2. Every implied address ip + x (for x < n) will be a valid IPv4 address.<br>
 * 3. n will be an integer in the range [1, 1000].
 */
public class IPToCIDR {
    
    public static List<String> solution(String ip, int n) {
        long x = 0;        
        String[] ips = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            x <<= 8;
            x += Integer.parseInt(ips[i]);
        }
        
        List<String> result = new ArrayList<>();
        while (n > 0) {
            long step = x & -x;            
            while (step > n) {
                step /= 2;
            }            
            result.add(toIP(x, (int) step));
            x += step;
            n -= step;
        }
        
        return result;
    }
    
    private static String toIP(long x, int step) {
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = (int) (x & 0xff);
            x >>= 8;
        }
        
        int len = 33;
        while (step > 0) {
            len--;
            step /= 2;
        }
        return result[3] + "." + result[2] + "." + result[1] + "." + result[0] + "/" + len;
    }
    
    public static void main(String[] args) {
        System.out.println(IPToCIDR.solution("255.0.0.7", 10));
    }

}
