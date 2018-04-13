package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 323. Number of Connected Components in an Undirected Graph<br>
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph<br><br>
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a 
 * function to find the number of connected components in an undirected graph.<br>
 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the 
 * same as [1, 0] and thus will not appear together in edges.
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
    
    public static int solution(int n, int[][] edges) {
        int count = n;
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            
            int xRoot = find(id, x);
            int yRoot = find(id, y);
            if (xRoot != yRoot) {
                id[xRoot] = id[yRoot];
                count--;
            }
        }
        System.out.println(Arrays.toString(id));
        return count;
    }
    
    private static int find(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression
            i = id[i];
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };
        System.out.println(NumberOfConnectedComponentsInUndirectedGraph.solution(5, edges));
        
        int[][] edges2 = { {0, 1}, {1, 2}, {2, 3}, {3, 4} };
        System.out.println(NumberOfConnectedComponentsInUndirectedGraph.solution(5, edges2));
    }

}
