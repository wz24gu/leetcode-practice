package edu.wz.cs.leetcode.hard;

import java.util.Arrays;

/**
 * 803. Bricks Falling When Hit<br>
 * https://leetcode.com/problems/bricks-falling-when-hit<br><br>
 * 
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly 
 * connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.<br>
 * 
 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it 
 * exists) on that location will disappear, and then some other bricks may drop because of that erasure.<br>
 * 
 * Return an array representing the number of bricks that will drop after each erasure in sequence.<br><br>
 * 
 * Note:<br>
 * 1. The number of rows and columns in the grid will be in the range [1, 200].<br>
 * 2. The number of erasures will not exceed the area of the grid.<br>
 * 3. It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.<br>
 * 4. An erasure may refer to a location with no brick - if it does, no bricks drop.
 */
public class BricksFallingWhenHit {
    
    private static class UnionFind {
        int[] parent;
        int[] rank;
        int[] size;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
                size[i] = 1;
            }
        }
        
        public int find(int i) {
            if (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        public void union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return;
            }
            
            if (rank[iRoot] < rank[jRoot]) {
                parent[iRoot] = jRoot;
                size[jRoot] += size[iRoot];
            }
            else {
                parent[jRoot] = iRoot;
                size[iRoot] += size[jRoot];
            }
        }
        
        public int getSize(int i) {
            return size[find(i)];
        }
        
        public int getTop() {
            return getSize(size.length - 1) - 1;
        }
        
    }
    
    public static int[] solution(int[][] grid, int[][] hits) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new int[0];
        }
        if (hits == null || hits.length == 0 || hits[0].length == 0) {
            return new int[0];
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            copy[i] = grid[i].clone();
        }
        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        
        UnionFind uf = new UnionFind(m * n + 1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 1) {
                    int idx = i * n + j;
                    if (i == 0) {
                        uf.union(idx, m * n);
                    }
                    if (i > 0 && copy[i-1][j] == 1) {
                        uf.union(idx, (i - 1) * n + j);
                    }
                    if (j > 0 && copy[i][j-1] == 1) {
                        uf.union(idx, i * n + j - 1);
                    }
                }
            }
        }
        
        int[][] dirs = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        int t = hits.length;
        int[] res = new int[t--];
        
        while (t >= 0) {
            int i = hits[t][0];
            int j = hits[t][1];
            int preSize = uf.getTop();
            
            if (grid[i][j] == 0) {
                t--;
            }
            else {
                int idx = i * n + j;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >=0 && y < n && copy[x][y] == 1) {
                        uf.union(idx, x * n + y);
                    }
                }
                
                if (i == 0) {
                    uf.union(idx, m * n);
                }
                copy[i][j] = 1;
                res[t] = Math.max(0, uf.getTop() - preSize - 1);
                t--;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] grid = { {1, 0, 0, 0},
                         {1, 1, 1, 0} };
        int[][] hits = { {1, 0} };
        System.out.println(Arrays.toString(BricksFallingWhenHit.solution(grid, hits)));
        
        int[][] grid2 = { {1, 0, 0, 0},
                          {1, 1, 0, 0} };
        int[][] hits2 = { {1, 1}, {1, 0} };
        System.out.println(Arrays.toString(BricksFallingWhenHit.solution(grid2, hits2)));
    }

}
