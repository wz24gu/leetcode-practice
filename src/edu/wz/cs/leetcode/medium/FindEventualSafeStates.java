package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 802. Find Eventual Safe States<br>
 * https://leetcode.com/problems/find-eventual-safe-states<br><br>
 * 
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a 
 * node that is terminal (that is, it has no outgoing directed edges), we stop.<br>
 * 
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node. More 
 * specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a 
 * terminal node in less than K steps.<br>
 * 
 * Which nodes are eventually safe?  Return them as an array in sorted order.<br>
 * 
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the 
 * following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.<br><br>
 * 
 * Note:<br>
 * 1. graph will have length at most 10000.<br>
 * 2. The number of edges in the graph will not exceed 32000.<br>
 * 3. Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class FindEventualSafeStates {
    
    @SuppressWarnings("unchecked")
    public static List<Integer> solution(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        List<Integer>[] g = (List<Integer>[]) new List[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            g[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                g[j].add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            
            for (int w : g[v]) {
                outdegree[w]--;
                if (outdegree[w] == 0) {
                    queue.offer(w);
                }
            }
        }
        
        Collections.sort(res);
        return res;        
    }
    
    public static void main(String[] args) {
        int[][] graph = { {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {} };
        System.out.println(FindEventualSafeStates.solution(graph));
    }

}
