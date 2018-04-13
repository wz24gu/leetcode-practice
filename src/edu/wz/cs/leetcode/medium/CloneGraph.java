package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import edu.wz.cs.leetcode.model.UndirectedGraphNode;

/**
 * 133. Clone Graph<br>
 * https://leetcode.com/problems/clone-graph<br><br>
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.<br>
 * 
 * OJ's undirected graph serialization:<br>
 * 
 * Nodes are labeled uniquely.<br>
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.<br>
 * 
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.<br>
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.<br>
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.<br>
 * Second node is labeled as 1. Connect node 1 to node 2.<br>
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 */
public class CloneGraph {
    
    public static UndirectedGraphNode solution(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    private static UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);        
        for (UndirectedGraphNode neighbor : node.neighbors) {
            helper(neighbor, map);
        }
        
        return newNode;
    }
    
    public static UndirectedGraphNode solutionAlt(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        Map<Integer, UndirectedGraphNode> map1 = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map1.put(node.label, newNode);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for (UndirectedGraphNode neighbor : curr.neighbors) {
                if (!map1.containsKey(neighbor.label)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map1.put(neighbor.label, newNeighbor);
                    queue.offer(neighbor);
                }
                map1.get(curr.label).neighbors.add(map1.get(neighbor.label));
            }
        }
        
        return newNode;
    }
    
    public static void main(String[] args) {
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        
        System.out.println(CloneGraph.solution(node1));
        System.out.println(CloneGraph.solutionAlt(node1));        
    }

}
