package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 760. Find Anagram Mappings<br>
 * https://leetcode.com/problems/find-anagram-mappings<br><br>
 * 
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of 
 * the elements in A.<br>
 * 
 * We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.<br>
 * 
 * These lists A and B may contain duplicates. If there are multiple answers, output any of them.<br><br>
 * 
 * Note:<br>
 * A, B have equal lengths in range [1, 100].<br>
 * A[i], B[i] are integers in range [0, 10^5].
 */
public class FindAnagramMappings {
    
    public static int[] solution(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = B.length;
        for (int i = 0; i < n; i++) {
            map.put(B[i], i);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(map.get(A[i]));
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(FindAnagramMappings.solution(A, B)));
    }

}
