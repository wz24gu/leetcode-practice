package edu.wz.cs.leetcode.medium;

/**
 * 362. Design Hit Counter<br>
 * https://leetcode.com/problems/design-hit-counter<br><br>
 * 
 * Follow up: What if the number of hits per second could be very large? Does your design scale?
 */
public class DesignHitCounterFollowup {
    
    int[] times;
    int[] hits;
    
    public DesignHitCounterFollowup() {
        times = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {
        int idx = timestamp % 300;
        if (times[idx] == timestamp) {
            hits[idx]++;
        }
        else {
            times[idx] = timestamp;
            hits[idx] = 1;
        }
    }
    
    public int getHits(int timestamp) {
        int count = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                count += hits[i];
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        DesignHitCounterFollowup counter = new DesignHitCounterFollowup();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }

}
