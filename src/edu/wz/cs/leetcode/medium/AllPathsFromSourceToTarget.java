package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target<br>
 * https://leetcode.com/problems/all-paths-from-source-to-target<br><br>
 * 
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any 
 * order.<br>
 * 
 * The graph is given as follows: the nodes are 0, 1, ..., graph.length - 1. graph[i] is a list of all nodes j for which 
 * the edge (i, j) exists.<br><br>
 * 
 * Note:<br>
 * 1. The number of nodes in the graph will be in the range [2, 15].<br>
 * 2. You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourceToTarget {
    
    public static List<List<Integer>> solution(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    }
    
    private static void dfs(int[][] graph, int v, List<Integer> path, List<List<Integer>> res) {
        if (v == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int w : graph[v]) {
            path.add(w);
            dfs(graph, w, path, res);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[][] graph = { {1, 2}, {3}, {3}, {} };
        System.out.println(AllPathsFromSourceToTarget.solution(graph));
    }

}
