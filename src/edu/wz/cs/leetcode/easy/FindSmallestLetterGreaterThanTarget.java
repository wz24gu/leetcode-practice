package edu.wz.cs.leetcode.easy;

/**
 * 744. Find Smallest Letter Greater Than Target<br>
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target<br><br>
 * 
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find 
 * the smallest element in the list that is larger than the given target.<br>
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.<br><br>
 * 
 * Note:<br>
 * 1. letters has a length in range [2, 10000].<br>
 * 2. letters consists of lowercase letters, and contains at least 2 unique letters.<br>
 * 3. target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    
    public static char solution(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        
        return lo == letters.length ? letters[0] : letters[lo];
    }
    
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'a'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'c'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'd'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'g'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'j'));
        System.out.println(FindSmallestLetterGreaterThanTarget.solution(letters, 'k'));
    }

}
