package edu.wz.cs.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule<br>
 * https://leetcode.com/problems/course-schedule<br><br>
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.<br>
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is 
 * expressed as a pair: [0,1]<br>
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?<br><br>
 * 
 *  Note:<br>
 *  1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a 
 *  graph is represented.<br>
 *  2. You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    
    @SuppressWarnings("unchecked")
    public static boolean solution(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            int prev = pre[1];
            int curr = pre[0];
            if (graph[prev] == null) {
                graph[prev] = new LinkedList<Integer>();
            }
            graph[prev].add(curr);
            indegree[curr]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();  // Kahn's algorithm, this is the topological order
            count++;
            if (graph[v] == null) {
                continue;
            }
            
            for (int w : graph[v]) {
                indegree[w]--;
                if (indegree[w] == 0) {
                    queue.offer(w);
                }
            }
        }
        
        return count == numCourses;
    }
    
    public static void main(String[] args) {
        int[][] prerequisites= { {1, 0} };
        System.out.println(CourseSchedule.solution(2, prerequisites));
        
        int[][] prerequisites2= { {1, 0}, {0, 1} };
        System.out.println(CourseSchedule.solution(2, prerequisites2));
    }

}
