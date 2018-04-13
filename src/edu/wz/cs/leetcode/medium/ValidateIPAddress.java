package edu.wz.cs.leetcode.medium;

/**
 * 468. Validate IP Address<br>
 * https://leetcode.com/problems/validate-ip-address<br><br>
 * 
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.<br>
 * 
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each 
 * ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;<br>
 * 
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.<br>
 * 
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The 
 * groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. 
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to 
 * upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper 
 * cases).<br>
 * 
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) 
 * to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.<br>
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 
 * is invalid.<br>
 * 
 * Note: You may assume there is no extra space or special characters in the input string.
 */
public class ValidateIPAddress {
    
    public static String solution(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        
        if (ip4(IP)) {
            return "IPv4";
        }
        if (ip6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }
    
    private static boolean ip4(String IP) {
        int n = IP.length();
        if (IP.charAt(0) == '.' || IP.charAt(n - 1) == '.') {
            return false;
        }
        
        String[] fields = IP.split("\\.");
        if (fields.length != 4) {
            return false;
        }
        for (String field : fields) {
            if (field.length() > 1 && field.charAt(0) == '0') {
                return false;
            }
            try {
                if (Integer.parseInt(field) > 255 || field.charAt(0) == '+' || field.charAt(0) == '-') {
                    return false;
                }                
            }
            catch (NumberFormatException e) {
                return false;
            }            
        }
        
        return true;
    }
    
    private static boolean ip6(String IP) {
        int n = IP.length();
        if (IP.charAt(0) == ':' || IP.charAt(n - 1) == ':') {
            return false;
        }
        
        String[] fields = IP.split(":");
        if (fields.length != 8) {
            return false;
        }
        for (String field : fields) {
            if (field.length() == 0 || field.length() > 4) {
                return false;
            }
            for (char c : field.toCharArray()) {
                if (c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F') {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(ValidateIPAddress.solution("172.16.254.1"));
        System.out.println(ValidateIPAddress.solution("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(ValidateIPAddress.solution("256.256.256.256"));
    }

}
