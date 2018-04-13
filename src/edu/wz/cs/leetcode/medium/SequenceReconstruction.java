package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 444. Sequence Reconstruction<br>
 * https://leetcode.com/problems/sequence-reconstruction<br><br>
 * 
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is
 * a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence 
 * of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine 
 * whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.<br>
 * 
 * UPDATE (2017/1/8):<br>
 * The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). Please reload 
 * the code definition to get the latest changes.
 */
public class SequenceReconstruction {
    
    public static boolean solution(int[] org, List<List<Integer>> seqs) {
        if (seqs.isEmpty()) {
            return false;
        }
        
        int n = org.length;
        int count = n - 1;
        int[] pos = new int[n+1];
        int[] flag = new int[n+1];
        boolean existed = false;
        
        for (int i = 0; i < n; i++) {
            pos[org[i]] = i;
        }
        
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                existed = true;
                if (seq.get(i) < 0 || seq.get(i) > n) {
                    return false;
                }
                if (i == 0) {
                    continue;
                }
                int pre = seq.get(i - 1);
                int cur = seq.get(i);
                if (pos[pre] > pos[cur]) {
                    return false;
                }
                if (flag[cur] == 0 && pos[pre] + 1 == pos[cur]) {
                    flag[cur] = 1;
                    count--;
                }
            }
        }
        
        return count == 0 && existed;
    }
    
    public static void main(String[] args) {
        int[] org = {1, 2, 3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1, 2));
        System.out.println(SequenceReconstruction.solution(org, seqs));
        
        int[] org2 = {1, 2, 3};
        List<List<Integer>> seqs2 = new ArrayList<>();
        seqs2.add(Arrays.asList(1, 2));
        seqs2.add(Arrays.asList(1, 3));
        seqs2.add(Arrays.asList(2, 3));
        System.out.println(SequenceReconstruction.solution(org2, seqs2));
        
        int[] org3 = {1, 2, 3};
        List<List<Integer>> seqs3 = new ArrayList<>();
        seqs3.add(Arrays.asList(1, 2));
        seqs3.add(Arrays.asList(1, 3));
        System.out.println(SequenceReconstruction.solution(org3, seqs3));
        
        int[] org4 = {4, 1, 5, 2, 6, 3};
        List<List<Integer>> seqs4 = new ArrayList<>();
        seqs4.add(Arrays.asList(5, 2, 6, 3));
        seqs4.add(Arrays.asList(4, 1, 5, 2));
        System.out.println(SequenceReconstruction.solution(org4, seqs4));
    }

}
