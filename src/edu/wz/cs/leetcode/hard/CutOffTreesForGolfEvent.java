package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 675. Cut Off Trees for Golf Event<br>
 * https://leetcode.com/problems/cut-off-trees-for-golf-event<br><br>
 * 
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, 
 * in this map:<br>
 * 0 represents the obstacle can't be reached.<br>
 * 1 represents the ground can be walked through.<br>
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the 
 * tree's height.<br><br>
 * 
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with 
 * lowest height first. And after cutting, the original place has the tree will become a grass (value 1).<br>
 * 
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the 
 * trees. If you can't cut off all the trees, output -1 in that situation.<br>
 * 
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.<br>
 * 
 * Hint: size of the given matrix will not exceed 50x50.
 */
public class CutOffTreesForGolfEvent {
    
    private static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    
    public static int solution(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty() || forest.get(0).isEmpty()) {
            return 0;
        }
        
        int m = forest.size();
        int n = forest.get(0).size();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);  // (x, y, height)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        
        int[] start = {0, 0};
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int[] next = {tree[0], tree[1]};
            int step = minStep(forest, start, next, m, n);
            
            if (step < 0) {
                return -1;
            }
            sum += step;
            
            start[0] = next[0];
            start[1] = next[1];
        }        
        return sum;   
    }
    
    private static int minStep(List<List<Integer>> forest, int[] start, int[] end, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];        
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == end[0] && curr[1] == end[1]) {
                    return step;
                }
                
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && forest.get(x).get(y) != 0) {
                        queue.add(new int[] {x, y});
                        visited[x][y]= true;
                    }
                }                
            }
            step++;
        }
        
        return -1;        
    }
    
    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(new Integer[] {1, 2, 3}));
        forest.add(Arrays.asList(new Integer[] {0, 0, 4}));
        forest.add(Arrays.asList(new Integer[] {7, 6, 5}));
        System.out.println(CutOffTreesForGolfEvent.solution(forest));
        
        List<List<Integer>> forest2 = new ArrayList<>();
        forest2.add(Arrays.asList(new Integer[] {1, 2, 3}));
        forest2.add(Arrays.asList(new Integer[] {0, 0, 0}));
        forest2.add(Arrays.asList(new Integer[] {7, 6, 5}));
        System.out.println(CutOffTreesForGolfEvent.solution(forest2));
        
        List<List<Integer>> forest3 = new ArrayList<>();
        forest3.add(Arrays.asList(new Integer[] {2, 3, 4}));
        forest3.add(Arrays.asList(new Integer[] {0, 0, 5}));
        forest3.add(Arrays.asList(new Integer[] {8, 7, 6}));
        System.out.println(CutOffTreesForGolfEvent.solution(forest3));
    }

}
