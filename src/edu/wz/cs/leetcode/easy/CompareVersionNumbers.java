package edu.wz.cs.leetcode.easy;

/**
 * 165. Compare Version Numbers<br/>
 * https://leetcode.com/problems/compare-version-numbers<br/><br/>
 * 
 * Compare two version numbers version1 and version2. If version1 > version2 return 1, if version1 < version2 return -1, 
 * otherwise return 0.<br/>
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character. The . character 
 * does not represent a decimal point and is used to separate number sequences.<br/>
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of 
 * the second first-level revision.<br/>
 * 
 * Here is an example of version numbers ordering: 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    
    public static int solution(String version1, String version2) {
        String[] field1 = version1.split("\\.");
        String[] field2 = version2.split("\\.");
        
        int max = Math.max(field1.length, field2.length);
        for (int i = 0; i < max; i++) {
            int a = i < field1.length ? Integer.parseInt(field1[i]) : 0;
            int b = i < field2.length ? Integer.parseInt(field2[i]) : 0;
            if (a == b) {
                continue;
            }
            return a < b ? -1 : 1;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(CompareVersionNumbers.solution("1.1.2", "1.1.2.1"));
        System.out.println(CompareVersionNumbers.solution("1.1.2.1", "1.1.2.1"));
        System.out.println(CompareVersionNumbers.solution("1.1.2.0", "1.1.2"));
    }

}
