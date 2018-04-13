package edu.wz.cs.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite?<br>
 * https://leetcode.com/problems/is-graph-bipartite<br><br>
 * 
 * Given an undirected graph, return true if and only if it is bipartite.<br>
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that 
 * every edge in the graph has one node in A and another node in B.<br>
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j 
 * exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] 
 * does not contain i, and it doesn't contain any element twice.<br><br>
 * 
 * Note:<br>
 * 1. graph will have length in range [1, 100].<br>
 * 2. graph[i] will contain integers in range [0, graph.length - 1].<br>
 * 3. graph[i] will not contain i or duplicate values.<br>
 * 4. The graph is undirected: if any element j is in graph[i], then i will be in graph[j].
 */
public class IsGraphBipartite {
    
    public static boolean solution(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!valid(graph, colors, 0, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean valid(int[][] graph, int[] colors, int color, int v) {
        if (colors[v] != -1) {
            return colors[v] == color;
        }
        
        colors[v] = color;
        for (int w : graph[v]) {
            if (!valid(graph, colors, 1 - color, w)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solutionBFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);        
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {                
                color[i] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w : graph[v]) {
                        if (color[w] == -1) {
                            color[w] = (color[v] == 0) ? 1 : 0;
                            queue.offer(w);
                        }
                        else if (color[w] == color[v]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[][] graph = { {1, 3}, {0, 2}, {1, 3}, {0, 2} };
        System.out.println(IsGraphBipartite.solution(graph));
        System.out.println(IsGraphBipartite.solutionBFS(graph));
        
        int[][] graph2 = { {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2} };
        System.out.println(IsGraphBipartite.solution(graph2));
        System.out.println(IsGraphBipartite.solutionBFS(graph2));
    }

}
