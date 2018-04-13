package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 261. Graph Valid Tree<br>
 * https://leetcode.com/problems/graph-valid-tree<br><br>
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function 
 * to check whether these edges make up a valid tree.<br>
 * 
 * For example:<br>
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.<br>
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.<br>
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same 
 * as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    
    public static boolean solutionUnionFind(int n, int[][] edges) {
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        
        for (int[] edge : edges) {
            int x = find(id, edge[0]);
            int y = find(id, edge[1]);
            if (x == y) {
                return false;
            }
            id[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    private static int find(int[] id, int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];  // path compression
            i = id[i];
        }
        return i;
    }
    
    public static boolean solutionDFS(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            list.get(v).add(w);
            list.get(w).add(v);
        }
        
        boolean[] marked = new boolean[n];
        
        if (hasCycle(list, 0, -1, marked)) {
            return false;
        }
        
        for (boolean m : marked) {
            if (!m) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean hasCycle(List<List<Integer>> list, int v, int pre, boolean[] marked) {
        marked[v] = true;
        for (int w : list.get(v)) {
            if (marked[w] && pre != w
                    || !marked[w] && hasCycle(list, w, v, marked)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean solutionBFS(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            list.get(v).add(w);
            list.get(w).add(v);
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int v = queue.poll();            
            for (int w : list.get(v)) {
                if (set.contains(w)) {
                    return false;
                }
                queue.add(w);
                set.add(w);
                int idx = list.get(w).indexOf(v);
                list.get(w).remove(idx);
            }
        }
        
        return set.size() == n;
    }
    
    public static void main(String[] args) {
        int[][] edges = { {0, 1}, {0, 2}, {0, 3}, {1, 4} };
        System.out.println(GraphValidTree.solutionUnionFind(5, edges));
        System.out.println(GraphValidTree.solutionDFS(5, edges));
        System.out.println(GraphValidTree.solutionBFS(5, edges));
        
        int[][] edges2 = { {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4} };
        System.out.println(GraphValidTree.solutionUnionFind(5, edges2));
        System.out.println(GraphValidTree.solutionDFS(5, edges2));
        System.out.println(GraphValidTree.solutionBFS(5, edges2));
    }

}
