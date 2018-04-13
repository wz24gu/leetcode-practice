package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 787. Cheapest Flights Within K Stops<br>
 * https://leetcode.com/problems/cheapest-flights-within-k-stops<br><br>
 * 
 * There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.<br>
 * 
 * Now given all the cities and fights, together with starting city src and the destination dst, your task is to find 
 * the cheapest price from src to dst with up to k stops. If there is no such route, output -1.<br><br>
 * 
 * Note:<br>
 * 1. The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.<br>
 * 2. The size of flights will be in range [0, n * (n - 1) / 2].<br>
 * 3. The format of each flight will be (src, dst, price).<br>
 * 4. The price of each flight will be in the range [1, 10000].<br>
 * 5. k is in the range of [0, n - 1].<br>
 * 6. There will not be any duplicated flights or self cycles.
 */
public class CheapestFlightsWithinKStops {
    
    public static int solution(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            if (!map.containsKey(f[0])) {
                map.put(f[0], new HashMap<Integer, Integer>());
            }
            map.get(f[0]).put(f[1], f[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, src, K + 1});
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int price = top[0];
            int city = top[1];
            int stop = top[2];
            if (city == dst) {
                return price;
            }
            
            if (stop > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(city, new HashMap<Integer, Integer>());
                for (int a : adj.keySet()) {
                    pq.offer(new int[] {price + adj.get(a), a, stop - 1});
                }
            }   
        }
        
        return -1;   
    }
    
    public static void main(String[] args) {
        int[][] flights = { {0, 1, 100}, {1, 2, 100}, {0, 2, 500} };
        System.out.println(CheapestFlightsWithinKStops.solution(3, flights, 0, 2, 1));
        System.out.println(CheapestFlightsWithinKStops.solution(3, flights, 0, 2, 0));
    }

}
