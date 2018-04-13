package edu.wz.cs.leetcode.hard;

import java.util.Map;
import java.util.TreeMap;

/**
 * 726. Number of Atoms<br>
 * https://leetcode.com/problems/number-of-atoms<br><br>
 * 
 * Given a chemical formula (given as a string), return the count of each atom.<br>
 * 
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.<br>
 * 
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, 
 * no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.<br>
 * 
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.<br>
 * 
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 
 * are formulas.<br>
 * 
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), 
 * followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its 
 * count (if that count is more than 1), and so on.<br><br>
 * 
 * Note:<br>
 * 1. All atom names consist of lowercase letters, except for the first character which is uppercase.<br>
 * 2. The length of formula will be in the range [1, 1000].<br>
 * 3. formula will only consist of letters, digits, and round parentheses, and is a valid formula as defined in the problem.
 */
public class NumberOfAtoms {
    
    public static String solution(String formula) {
        Map<String, Integer> map = helper(formula);
        
        StringBuilder sb = new StringBuilder();
        for (String atom : map.keySet()) {
            sb.append(atom);
            if (map.get(atom) > 1) {
                sb.append(map.get(atom));
            }
        }
        return sb.toString();   
    }
    
    private static Map<String, Integer> helper(String formula) {
        Map<String, Integer> map = new TreeMap<>();
        if (formula == null || formula.isEmpty()) {
            return map;
        }
        
        int n = formula.length();
        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                int count = 0;
                int j;
                for (j = i; j < n; j++) {
                    if (formula.charAt(j) == '(') {
                        count++;
                    }
                    else if (formula.charAt(j) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                Map<String, Integer> sub = helper(formula.substring(i + 1, j));
                
                j++;
                int m = 1;
                int k = j;
                while (k < n && formula.charAt(k) >= '0' && formula.charAt(k) <= '9') {
                    k++;
                }
                if (k > j) {
                    m = Integer.parseInt(formula.substring(j, k));
                }
                
                for (String atom : sub.keySet()) {
                    map.put(atom, sub.get(atom) * m + map.getOrDefault(atom, 0));
                }
                i = k;
            }
            else {
                int j = i + 1;
                while (j < n && formula.charAt(j) >= 'a' && formula.charAt(j) <= 'z') {
                    j++;
                }
                
                int m = 1;
                int k = j;
                while (k < n && formula.charAt(k) >= '0' && formula.charAt(k) <= '9') {
                    k++;
                }
                if (k > j) {
                    m = Integer.parseInt(formula.substring(j, k));
                }
                
                String atom = formula.substring(i, j);
                map.put(atom, m + map.getOrDefault(atom, 0));
                i = k;
            }
        }
        
        return map;
    }
    
    public static void main(String[] args) {
        System.out.println(NumberOfAtoms.solution("H2O"));
        System.out.println(NumberOfAtoms.solution("Mg(OH)2"));
        System.out.println(NumberOfAtoms.solution("K4(ON(SO3)2)2"));
    }

}
