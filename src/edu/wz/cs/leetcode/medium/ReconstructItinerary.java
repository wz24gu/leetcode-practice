package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 332. Reconstruct Itinerary<br>
 * https://leetcode.com/problems/reconstruct-itinerary<br><br>
 * 
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the 
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.<br><br>
 * 
 * Note:<br>
 * 1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when 
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].<br>
 * 2. All airports are represented by three capital letters (IATA code).<br>
 * 3. You may assume all tickets form at least one valid itinerary.
 */
public class ReconstructItinerary {
    
    public static List<String> solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        
        dfs(map, "JFK", result);
        return result;
    }
    
    private static void dfs(Map<String, Queue<String>> map, String s, List<String> result) {
        while (map.containsKey(s) && !map.get(s).isEmpty()) {
            String t = map.get(s).poll();
            dfs(map, t, result);
        }
        result.add(0, s);
    }
    
    public static List<String> solutionAlt(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        
        Map<String, Queue<String>> map = new HashMap<>();
        for (String[] ticket: tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }        
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        
        while (!stack.isEmpty()) {
            String t = stack.peek();
            if (map.containsKey(t)) {
                if (map.get(t).isEmpty()) {
                    result.add(0, t);
                    stack.pop();                
                }
                else {
                    stack.push(map.get(t).poll());
                }   
            }
            else {
                result.add(0, stack.pop());
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String[][] tickets = { {"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"} };
        System.out.println(ReconstructItinerary.solution(tickets));
        System.out.println(ReconstructItinerary.solutionAlt(tickets));
        
        String[][] tickets2 = { {"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"} };
        System.out.println(ReconstructItinerary.solution(tickets2));
        System.out.println(ReconstructItinerary.solutionAlt(tickets2));
    }

}
