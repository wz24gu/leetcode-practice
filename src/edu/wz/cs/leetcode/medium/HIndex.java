package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 274. H-Index<br>
 * https://leetcode.com/problems/h-index<br><br>
 * 
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the 
 * researcher's h-index.<br>
 * 
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least 
 * h citations each, and the other N − h papers have no more than h citations each."<br>
 * 
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had 
 * received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and 
 * the remaining two with no more than 3 citations each, his h-index is 3.<br>
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {
    
    public static int solution(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int n = citations.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int temp = citations[i];
            citations[i] = citations[j];
            citations[j] = temp;
            i++;
            j--;
        }
        
        for (int k = 0; k < n; k++) {
            if (k >= citations[k]) {
                return k;
            }
        }
        return n;
    }
    
    public static int solutionAlt(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (n - i - 1 >= citations[i]) {
                return n - i - 1;
            }
        }
        return n;
    }
    
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(HIndex.solution(citations));
        System.out.println(HIndex.solutionAlt(citations));
    }

}
