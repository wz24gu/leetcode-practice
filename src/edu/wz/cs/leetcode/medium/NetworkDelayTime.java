package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 743. Network Delay Time<br>
 * https://leetcode.com/problems/network-delay-time<br><br>
 * 
 * There are N network nodes, labelled 1 to N.<br>
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the 
 * target node, and w is the time it takes for a signal to travel from source to target.<br>
 * 
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is 
 * impossible, return -1.<br>
 * 
 * Note:<br>
 * 1. N will be in the range [1, 100].<br>
 * 2. K will be in the range [1, N].<br>
 * 3. The length of times will be in the range [1, 6000].<br>
 * 4. All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime {
    
    public static int solution(int[][] times, int N, int K) {
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] t = times[i];
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<>());
            }
            map.get(t[0]).add(i);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> time[a] - time[b]);
        pq.offer(K);
        time[K] = 0;
        int count = 0;
        
        while (!pq.isEmpty()) {
            int node = pq.poll();
            count++;
            if (count == N) {
                break;
            }
            
            List<Integer> next = map.get(node);
            if (next == null) {
                continue;
            }
            for (int i : next) {
                int v = times[i][1];
                int t = times[i][2];
                if (t + time[node] < time[v]) {
                    time[v] = t + time[node];
                    pq.remove(v);
                    pq.offer(v);
                }
            }            
        }
        
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (time[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, time[i]);
        }
        return res;
    }
}
