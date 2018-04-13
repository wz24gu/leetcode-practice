package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 502. IPO<br/>
 * 
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode 
 * would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can 
 * only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total 
 * capital after finishing at most k distinct projects.<br/>
 * 
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to 
 * start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure 
 * profit and the profit will be added to your total capital.<br/>
 * 
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output 
 * your final maximized capital.<br/><br/>
 * 
 * Note:<br/>
 * 1. You may assume all numbers in the input are non-negative integers.<br/>
 * 2. The length of Profits array and Capital array will not exceed 50,000.<br/>
 * 3. The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {
    
    private static class Pair {
        public int capital;
        public int profit;
        public Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }    
    
    public static int solution(int k, int W, int[] Profits, int[] Capitals) {
        int n = Profits.length;
        
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(Capitals[i], Profits[i]));
        }
        Collections.sort(pairs, (a, b) -> a.capital - b.capital);  // sorting by capital ASC
        
        for (int i = 0; i < k; i++) {
            int max = 0;
            int index = 0;
            
            int lo = 0;
            int hi = pairs.size();
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (pairs.get(mid).capital <= W) {
                    lo = mid + 1;
                }
                else {
                    hi = mid;  // hi will be the first pair whose capital > W
                }
            }
            
            for (int j = hi - 1; j >= 0 ; j--) {
                if (max < pairs.get(j).profit) {
                    max = pairs.get(j).profit;  // find the max profit from all pairs whose capital <= W
                    index = j;
                }
            }
            
            W += max;
            pairs.remove(index);
        }
        
        return W;        
    }
    
    public static int solutionX(int k, int W, int[] Profits, int[] Capitals) {
        PriorityQueue<int[]> pqCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // capital ASC
        PriorityQueue<int[]> pqProfit = new PriorityQueue<>((a, b) -> b[1] - b[0]);  // profit DSC
        
        int n = Profits.length;
        for (int i = 0; i < n; i++) {
            pqCapital.add(new int[] { Capitals[i], Profits[i] });
        }
        
        for (int i = 0; i < k; i++) {
            while (!pqCapital.isEmpty() && pqCapital.peek()[0] <= W) {
                pqProfit.add(pqCapital.poll());
            }
            
            if (pqProfit.isEmpty()) {
                break;
            }
            
            W += pqProfit.poll()[1];
        }
        
        return W;
    }
    
    public static void main(String[] args) {
        int[] Profits = {1, 2, 3};
        int[] Capitals = {0, 1, 1};
        System.out.println(IPO.solution(2, 0, Profits, Capitals));
        System.out.println(IPO.solutionX(2, 0, Profits, Capitals));
    }

}
