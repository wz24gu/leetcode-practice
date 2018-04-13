package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 310. Minimum Height Trees<br>
 * https://leetcode.com/problems/minimum-height-trees<br><br>
 * 
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a 
 * rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
 * Given such a graph, write a function to find all the MHTs and return a list of their root labels.<br>
 * 
 * Format:<br>
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected 
 * edges (each edge is a pair of labels).<br>
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as 
 * [1, 0] and thus will not appear together in edges.<br><br>
 * 
 * Note:<br>
 * 1. According to the definition of tree on Wikipedia: "a tree is an undirected graph in which any two vertices are 
 * connected by exactly one path. In other words, any connected graph without simple cycles is a tree."<br>
 * 2. The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
public class MinimumHeightTrees {
    
    public static List<Integer> solution(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            adj.get(v).add(w);
            adj.get(w).add(v);
        }
        
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                result.add(i);
            }
        }
        
        while (n > 2) {
            n -= result.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i : result) {
                int t = adj.get(i).iterator().next();
                adj.get(t).remove(i);
                if (adj.get(t).size() == 1) {
                    tmp.add(t);
                }
            }
            result = tmp;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] edges = { {1, 0}, {1, 2}, {1, 3} };
        System.out.println(MinimumHeightTrees.solution(4, edges));
        
        int[][] edges2 = { {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4} };
        System.out.println(MinimumHeightTrees.solution(6, edges2));
    }

}
