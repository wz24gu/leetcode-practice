package edu.wz.cs.leetcode.easy;

/**
 * 458. Poor Pigs<br/>
 * 
 * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the 
 * same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to 
 * figure out which bucket contains the poison within one hour.<br/>
 * 
 * Answer this question, and write an algorithm for the follow-up general case.<br/><br/>
 * 
 * Follow-up: If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to 
 * figure out the "poison" bucket within p minutes? There is exact one bucket with poison.
 */
public class PoorPigs {
    
    public static int solution(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie + 1;
        int pig = 0;
        while (Math.pow(n, pig) < buckets) {
            pig++;
        }
        return pig;        
    }
    
    public static void main(String[] args) {
        System.out.println(PoorPigs.solution(1000, 15, 60));
    }

}
