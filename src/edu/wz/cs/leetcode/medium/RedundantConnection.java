package edu.wz.cs.leetcode.medium;

import java.util.Arrays;

/**
 * 684. Redundant Connection<br>
 * https://leetcode.com/problems/redundant-connection<br><br>
 * 
 * In this problem, a tree is an undirected graph that is connected and has no cycles.<br>
 * 
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one 
 * additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already 
 * existed.<br>
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that 
 * represents an undirected edge connecting nodes u and v.<br>
 * 
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, 
 * return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with 
 * u < v.<br><br>
 * 
 * Note:<br>
 * 1. The size of the input 2D-array will be between 3 and 1000.<br>
 * 2. Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnection {
    
    public static int[] solution(int[][] edges) {
        int n = edges.length * 2;  // maximum vertices that n edges can have
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            int idx1 = find(id, v);
            int idx2 = find(id, w);
            if (idx1 == idx2) {
                return edge;  // find cycle
            }
            else {
                id[idx1] = idx2;  // union
            }            
        }
        
        return new int[0];        
    }
    
    private static int find(int[] id, int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return id[i];
    }
    
    public static void main(String[] args) {
        int[][] edges = { {1, 2}, {1, 3}, {2, 3} };
        System.out.println(Arrays.toString(RedundantConnection.solution(edges)));
        
        int[][] edges2 = { {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5} };
        System.out.println(Arrays.toString(RedundantConnection.solution(edges2)));
    }

}
