package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 399. Evaluate Division<br>
 * https://leetcode.com/problems/evaluate-division<br><br>
 * 
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real 
 * number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.<br>
 * 
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is 
 * no contradiction.
 */
public class EvaluateDivision {
    
    public static double[] solution(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairMap = new HashMap<>();
        Map<String, List<Double>> valueMap = new HashMap<>();
        
        int n = equations.length;
        for (int i = 0; i < n; i++) {
            String[] equation = equations[i];
            if (!pairMap.containsKey(equation[0])) {
                pairMap.put(equation[0], new ArrayList<String>());
                valueMap.put(equation[0], new ArrayList<Double>());
            }
            if (!pairMap.containsKey(equation[1])) {
                pairMap.put(equation[1], new ArrayList<String>());
                valueMap.put(equation[1], new ArrayList<Double>());
            }
            
            pairMap.get(equation[0]).add(equation[1]);
            pairMap.get(equation[1]).add(equation[0]);
            valueMap.get(equation[0]).add(values[i]);
            valueMap.get(equation[1]).add(1 / values[i]);
        }
        
        int m = queries.length;
        double[] result = new double[m];
        for (int i = 0; i < m; i++) {
            String[] query = queries[i];
            String start = query[0];
            String end = query[1];
            
            if (!pairMap.containsKey(start) || !pairMap.containsKey(end)) {
                result[i] = -1.0;
                continue;
            }            
            result[i] = dfs(start, end, pairMap, valueMap, new HashSet<String>(), 1.0);
        }
        
        return result;
    }
    
    private static double dfs(String start, String end,
            Map<String, List<String>> pairMap, Map<String, List<Double>> valueMap, Set<String> marked, double value) {
        if (marked.contains(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return value;
        }
        
        marked.add(start);
        
        List<String> pairList = pairMap.get(start);
        List<Double> valueList = valueMap.get(start);
        double tmp = -1.0;
        int n = pairList.size();
        for (int i = 0; i < n; i++) {
            tmp = dfs(pairList.get(i), end, pairMap, valueMap, marked, value * valueList.get(i));
            if (tmp != -1.0) {
                break;
            }
        }
        return tmp;
    }
    
    // TODO: implement with Graph
    
    public static void main(String[] args) {
        String[][] equations = { {"a", "b"}, {"b", "c"} };
        double[] values = {2.0, 3.0};
        String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        System.out.println(Arrays.toString(EvaluateDivision.solution(equations, values, queries)));
    }

}
