package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 685. Redundant Connection II<br/>
 * https://leetcode.com/problems/redundant-connection-ii<br/><br/>
 * 
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all 
 * other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has 
 * no parents.<br/>
 * 
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), 
 * with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not 
 * an edge that already existed.<br/>
 * 
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a 
 * directed edge connecting nodes u and v, where u is a parent of child v.<br/>
 * 
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple 
 * answers, return the answer that occurs last in the given 2D-array.<br/><br/>
 * 
 * Note:<br/>
 * 1. The size of the input 2D-array will be between 3 and 1000.<br/>
 * 2. Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnectionII {
    
    public static int[] solution(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        
        int n = edges.length;
        int[] parent = new int[n + 1];
        // try to find a node with two parents
        for (int i = 0 ; i < n; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            }
            else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;  // invalidate this edge, point it to a non-existent vertex
            }
        }
        
        // union find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
                       
            int father = edges[i][0];
            int child = edges[i][1];
            
            // find a cycle
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;   
    }
    
    private static int root(int[] parent, int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }
    
    public static void main(String[] args) {
        int[][] edges = { {1, 2}, {1, 3}, {2, 3} };
        System.out.println(Arrays.toString(RedundantConnectionII.solution(edges)));
        
        int[][] edges2 = { {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5} };
        System.out.println(Arrays.toString(RedundantConnectionII.solution(edges2)));
    }

}
