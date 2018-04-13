package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 364. Nested List Weight Sum II<br>
 * https://leetcode.com/problems/nested-list-weight-sum-ii<br><br>
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is 
 * either an integer, or a list -- whose elements may also be integers or other lists.<br>
 * 
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from 
 * bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 */
public class NestedListWeightSumII {
    
    private static interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
    
    // this implementation has errors
    public static int solution(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();        
        helper(nestedList, list, 0);
        
        int result = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            result += list.get(i) * (n - 1);  // top element more weight
        }
        return result;        
    }
    
    private static void helper(List<NestedInteger> nestedList, List<Integer> list, int depth) {
        int sum = 0;
        List<NestedInteger> next = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger();
            }
            else {
                next.addAll(ni.getList());
            }
        }
        
        list.add(depth, sum);
        if (!next.isEmpty()) {
            helper(next, list, depth + 1);
        }
    }
    
    public static int solutionX(List<NestedInteger> nestedList) {
        int total = 0;
        if (nestedList == null || nestedList.size() == 0) {
            return total;
        }
        
        int levelSum = 0;        
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    levelSum += ni.getInteger();
                }
                else {
                    nextLevel.addAll(ni.getList());
                }
            }
            total += levelSum;
            nestedList = nextLevel;
        }
        
        return total;
    }

}
