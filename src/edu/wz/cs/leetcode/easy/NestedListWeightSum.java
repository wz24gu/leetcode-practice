package edu.wz.cs.leetcode.easy;

import java.util.List;

import edu.wz.cs.leetcode.model.NestedInteger;

/**
 * 339. Nested List Weight Sum<br/>
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is
 * either an integer, or a list -- whose elements may also be integers or other lists.
 */
public class NestedListWeightSum {
    
    public static int solution(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        return dfs(nestedList, 1);
    }
    
    private static int dfs(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            }
            else {
                sum += dfs(ni.getList(), depth + 1);
            }
        }
        return sum;
    }

}
