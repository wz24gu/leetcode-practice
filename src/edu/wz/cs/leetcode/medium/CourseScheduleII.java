package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II<br>
 * https://leetcode.com/problems/course-schedule-ii<br><br>
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.<br>
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed 
 * as a pair: [0,1]<br>
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to 
 * finish all courses.<br>
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, 
 * return an empty array.<br><br>
 * 
 * Note:<br>
 * 1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a 
 * graph is represented.<br>
 * 2. You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleII {
    
    @SuppressWarnings("unchecked")
    public static int[] solution(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int v = pre[1];
            int w = pre[0];
            if (graph[v] == null) {
                graph[v] = new ArrayList<Integer>();
            }
            graph[v].add(w);
            indegree[w]++;
        }        
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            
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
        
        if (res.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] prerequisites = { {1, 0} };
        System.out.println(Arrays.toString(CourseScheduleII.solution(2, prerequisites)));
        
        int[][] prerequisites2 = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        System.out.println(Arrays.toString(CourseScheduleII.solution(4, prerequisites2)));
    }

}
