package edu.wz.cs.leetcode.medium;

/**
 * 275. H-Index II<br>
 * https://leetcode.com/problems/h-index-ii<br><br>
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexII {
    
    public static int solution(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] == n - mid) {
                return n - mid;
            }
            else if (citations[mid] > n - mid) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        
        return n - lo;
    }
    
    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(HIndexII.solution(citations));
    }

}
