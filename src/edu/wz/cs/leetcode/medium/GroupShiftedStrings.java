package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings<br>
 * https://leetcode.com/problems/group-shifted-strings<br><br>
 * 
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep 
 * "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"<br>
 * 
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting 
 * sequence.<br>
 * 
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:<br>
 * [<br>
 *     ["abc","bcd","xyz"],<br>
 *     ["az","ba"],<br>
 *     ["acef"],<br>
 *     ["a","z"]<br>
 * ]<br>
 * 
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
    
    public static List<List<String>> solution(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();            
            for (char c : str.toCharArray()) {
                int diff = c - str.charAt(0);
                if (diff < 0) {
                    diff += 26;
                }
                sb.append(diff).append("/");  // 12 != 1 and 2
            }
            
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(GroupShiftedStrings.solution(strings));
    }

}
