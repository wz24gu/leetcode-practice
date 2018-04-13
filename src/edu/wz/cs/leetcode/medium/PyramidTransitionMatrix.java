package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 756. Pyramid Transition Matrix<br>
 * https://leetcode.com/problems/pyramid-transition-matrix<br><br>
 * 
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like 'Z'.<br>
 * 
 * For every block of color 'C' we place not in the bottom row, we are placing it on top of a left block of color 'A' and 
 * right block of color 'B'. We are allowed to place the block there only if '(A, B, C)' is an allowed triple.<br>
 * 
 * We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples 
 * allowed. Each allowed triple is represented as a string of length 3.<br>
 * 
 * Return true if we can build the pyramid all the way to the top, otherwise false.<br><br>
 * 
 * Note:<br>
 * 1. bottom will be a string with length in range [2, 8].<br>
 * 2. allowed will have length in range [0, 200].<br>
 * 3. Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */
public class PyramidTransitionMatrix {
    
    public static boolean solution(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s.substring(2));
        }
        
        return helper(bottom, map);
    }
    
    private static boolean helper(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) {
            return true;
        }
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i+2))) {
                return false;
            }
        }
        
        List<String> list = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), list, map);
        for (String s : list) {
            if (helper(s, map)) {
                return true;
            }
        }
        return false;
    }
    
    private static void getList(String bottom, int idx, StringBuilder sb, List<String> list, Map<String, List<String>> map) {
        if (idx == bottom.length() - 1) {
            list.add(sb.toString());
            return;
        }
        
        for (String s : map.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, list, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(PyramidTransitionMatrix.solution("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF")));
        System.out.println(PyramidTransitionMatrix.solution("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
    }

}
