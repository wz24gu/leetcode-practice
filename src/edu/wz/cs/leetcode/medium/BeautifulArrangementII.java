package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 667. Beautiful Arrangement II<br>
 * https://leetcode.com/problems/beautiful-arrangement-ii<br><br>
 * 
 * Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 
 * to n and obeys the following requirement:<br>
 * 
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has 
 * exactly k distinct integers. If there are multiple answers, print any of them.<br>
 * 
 * Note: The n and k are in the range 1 <= k < n <= 104.
 */
public class BeautifulArrangementII {
    
    // for example, if n = 8, we have most k (n-1) when the array is like:
    // 8, 1, 7, 2, 6, 3, 5, 4 (k = n - 1)
    public static int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        int i = 1;
        int j = n;
        while (i <= j) {
            if (k > 1) {
                if (k % 2 == 0) {
                    list.add(j--);
                }
                else {
                    list.add(i++);
                }
                k--;
            }
            else {
                list.add(i++);
            }
        }
        
        int[] result = new int[list.size()];
        for (int a = 0; a < result.length; a++) {
            result[a] = list.get(a);
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(BeautifulArrangementII.solution(3, 1)));
        System.out.println(Arrays.toString(BeautifulArrangementII.solution(3, 2)));
    }

}
