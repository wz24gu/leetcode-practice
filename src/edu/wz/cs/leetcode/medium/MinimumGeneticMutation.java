package edu.wz.cs.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 433. Minimum Genetic Mutation<br>
 * https://leetcode.com/problems/minimum-genetic-mutation<br><br>
 * 
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".<br>
 * 
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as 
 * ONE single character changed in the gene string.<br>
 * 
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.<br>
 * 
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make 
 * it a valid gene string.<br>
 * 
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to 
 * mutate from "start" to "end". If there is no such a mutation, return -1.<br><br>
 * 
 * Note:<br>
 * 1. Starting point is assumed to be valid, so it might not be included in the bank.<br>
 * 2. If multiple mutations are needed, all mutations during in the sequence must be valid.<br>
 * 3. You may assume start and end string is not the same.
 */
public class MinimumGeneticMutation {
    
    public static int solution(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        
        char[] arr =  {'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> used = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        used.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                String current = queue.poll();
                if (current.equals(end)) {
                    return level;
                }
                
                char[] currArray = current.toCharArray();
                for (int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for (char c : arr) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if (!used.contains(next) && bankSet.contains(next)) {
                            used.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }                
            }
            level++;
        }        
        
        return -1;
    }
    
    public static void main(String[] args) {
        String[] bank = {"AACCGGTA"};
        System.out.println(MinimumGeneticMutation.solution("AACCGGTT", "AACCGGTA", bank));
        
        String[] bank2 = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(MinimumGeneticMutation.solution("AACCGGTT", "AAACGGTA", bank2));
        
        String[] bank3 = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(MinimumGeneticMutation.solution("AAAAACCC", "AACCCCCC", bank3));
    }

}
