package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 271. Encode and Decode Strings<br>
 * https://leetcode.com/problems/encode-and-decode-strings<br><br>
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is 
 * decoded back to the original list of strings.<br>
 * 
 * Implement the encode and decode methods.<br>
 * 
 * Note:<br>
 * 1. The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be 
 * generalized enough to work on any possible characters.<br>
 * 2. Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.<br>
 * 3. Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class EncodeAndDecodeStrings {
    
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        
        int n = s.length();
        int i = 0;        
        while (i < n) {
            int index = s.indexOf("/", i);
            int len = Integer.parseInt(s.substring(i, index));
            res.add(s.substring(index + 1, index + 1 + len));
            i = index + 1 + len;
        }
        return res;
    }
    
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("a", "ab", "abc"));
        System.out.println(EncodeAndDecodeStrings.encode(strs));
        System.out.println(EncodeAndDecodeStrings.decode(EncodeAndDecodeStrings.encode(strs)));
    }

}
